def calculate_subnet_details(prefix_length):
    subnet_mask = (1 << 32) - (1 << (32 - prefix_length))
    num_subnets = 2 ** (32 - prefix_length)
    num_ip_addresses = 2 ** (32 - prefix_length)
    num_hosts = num_ip_addresses - 2
    total_num_networks = 256 // num_subnets
    return (
        (subnet_mask >> 24) & 0xFF,
        (subnet_mask >> 16) & 0xFF,
        (subnet_mask >> 8) & 0xFF,
        subnet_mask & 0xFF,
        num_subnets,
        num_ip_addresses,
        num_hosts,
        total_num_networks,
    )

def find_ip_address_class(first_octet):
    first_octet = int(first_octet)
    if 1 <= first_octet <= 126:
        return "Class A"
    elif 128 <= first_octet <= 191:
        return "Class B"
    elif 192 <= first_octet <= 223:
        return "Class C"
    elif 224 <= first_octet <= 239:
        return "Class D (Multicast)"
    elif 240 <= first_octet <= 255:
        return "Class E (Reserved)"
    else:
        return "Unknown"

def main():
    ip_address = input("Enter IP address (e.g., 192.168.1.0): ")
    first_octet = ip_address.split(".")[0]
    prefix_length = int(input("Enter prefix length (e.g., 24 for /24): "))
    subnet_mask = calculate_subnet_details(prefix_length)
    ip_class = find_ip_address_class(first_octet)
    print("IP Address Class:", ip_class)
    print("Subnet Mask:", ".".join(str(octet) for octet in subnet_mask[:4]))
    print("Number of Subnets:", subnet_mask[4])
    print("Number of IP Addresses in each Subnet:", subnet_mask[5])
    print("Number of Hosts in each Subnet:", subnet_mask[6])

if __name__ == "__main__":
    main()
