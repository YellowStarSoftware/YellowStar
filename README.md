A kotlin computational geometry library.

Features:
- vector and matrix operations
- transformation matrices
- collision detection algorithms
    - circle vs line/ray/segment
	- sphere vs line/ray/segment
	- circle vs 2D AABB/OBB
	- sphere vs 3D AABB/OBB
	- circle vs plane
	
Probably upcoming features:
- update Quaternion to be more consistent with Complex
- update Vector4D to be more consistent with Vector2D/Vector3D
- collision detection algorithms that are ready on paper but not in the project yet:
    - cut cone vs sphere (it's useful for frustum culling)
    - cylinder vs sphere
	- plane vs line/ray/segment
	- polygon vs sphere
	- polygon vs line/ray/segment
	- polygon vs polygon
- kotlin multifield value classes support
- projection matrices
- lerp/slerp for Vector2D/Vector3D
- algorithms for checking if a point contains in an object

Author: Dmitry R