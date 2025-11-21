A kotlin computational geometry library.

Features:
- vector and matrix operations
- transformation matrices:
    - perspective projection matrix
	- orthographic projection matrix
	- parallel projection matrix
	- linear transformation matrix 
	- affine transformation matrix 
	- scaling matrix
	- translation matrix
	- interval mapping matrix
- collision detection algorithms:
    - circle vs line/ray/segment
	- sphere vs line/ray/segment
	- circle vs 2D AABB/OBB
	- sphere vs 3D AABB/OBB
	- circle vs plane
	- cut cone vs sphere
	- cylinder vs sphere
	- plane vs line/ray/segment
	- line vs line/ray/segment
- algorithms for checking if an object contains a point for:
    - circle
	- rectangle (aka AABB in 2D)
	- oriented rectangle (aka OBB in 2D)
    - sphere
	- cylinder
	- cut cone
	- bounding box (aka AABB in 3D)
	- oriented bounding box (aka OBB in 3D)
	
Probably upcoming features:
- collision detection algorithms that are ready on paper but not in the project yet:
	- polygon vs sphere
	- polygon vs line/ray/segment
	- polygon vs polygon
- polygon algorithms such as clipping
- kotlin multifield value classes support
- lerp/slerp for Vector2D/Vector3D

Author: Dmitry R