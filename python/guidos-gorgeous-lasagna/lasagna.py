
#TODO (student): define your EXPECTED_BAKE_TIME (required) and PREPARATION_TIME (optional) constants below.
EXPECTED_BAKE_TIME = 40

#TODO (student): Remove 'pass' and complete the 'bake_time_remaining()' function below.
def bake_time_remaining(elapsed_bake_time):

    """
    bake_time_remaining
    Returns:
        int: The remaining bake time (in minutes) derived from 'EXPECTED_BAKE_TIME'.

    Function that takes the actual minutes the lasagna has been in the oven as
    an argument and returns how many minutes the lasagna still needs to bake
    based on the `EXPECTED_BAKE_TIME`.
    """
    return EXPECTED_BAKE_TIME - elapsed_bake_time
def preparation_time_in_minutes(number_of_layers):
    """preparation_time_in_minutes

        Parameters:
            number_of_layers (int): The number of layers in the lasagna.

        Returns:
            int: The total time elapsed (in minutes) preparing

        This function takes one integer representing the number of lasagna
        layers.
        It calculates the total elapsed minutes spent cooking.

        """
    return number_of_layers * 2

def elapsed_time_in_minutes(number_of_layers, elapsed_bake_time):
    """Calculate the elapsed cooking time.

        Parameters:
            number_of_layers (int): The number of layers in the lasagna.
            elapsed_bake_time (int): Time the lasagna has been baking in the oven.

        Returns:
            int: The total time elapsed (in minutes) preparing and baking.

        This function takes two integers representing the number of lasagna
        layers and the time already spent baking the lasagna. It calculates
        the total elapsed minutes spent cooking (preparing + baking).

        """
    return (number_of_layers * 2) + elapsed_bake_time

print(EXPECTED_BAKE_TIME)

bake_time_remaining(1)
bake_time_remaining(2)
bake_time_remaining(5)
bake_time_remaining(10)
bake_time_remaining(15)
bake_time_remaining(23)
bake_time_remaining(33)
bake_time_remaining(39)

preparation_time_in_minutes(1)
preparation_time_in_minutes(2)
preparation_time_in_minutes(5)
preparation_time_in_minutes(8)
preparation_time_in_minutes(11)
preparation_time_in_minutes(15)

elapsed_time_in_minutes(1, 3)
elapsed_time_in_minutes(2, 7)
elapsed_time_in_minutes(5, 8)
elapsed_time_in_minutes(8, 4)
elapsed_time_in_minutes(11, 15)
elapsed_time_in_minutes(15, 20)


