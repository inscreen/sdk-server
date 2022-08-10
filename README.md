# inScreen's server-side SDKs

See README's of individual packages.

A changelog is available in the [GitHub releases page](https://github.com/inscreen/sdk-server/releases).

## Version numbers

We use the same SemVer scheme for all languages. That means that we sometimes "lie" in SemVer versions, but only in being too strict. If we truly have to break compatibility in the Python package, we'll increment the major version and then we'll do so for all other languages so that they match. That may cause a situation where
the Node.js package "5.0.0" is completely identical to "4.0.0".

### Major versions

Major version increments must be approved by the CTO. They must be done for any change that breaks backwards-compatibility. The combination of these two requirements may mean that we'll postpone changes that break backwards-compatibility for business reasons.

### Minor versions

Minor version increments should be done if a feature was added. Changes to documentation, bug fixes, and other trivial changes do not require a minor version increment.

### Patch versions

Patch version increments happen in all cases other than major or minor version increments.

## Feature matrix

<table>
    <thead>
        <tr>
            <th align="center">Capability</th>
            <th align="center">Sub-feature</th>
            <th align="center">Node.js</th>
            <th align="center">Python</th>
            <th align="center">Kotlin</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan="2"><code>createInScreenToken</code></td>
            <td>Basic usage</td>
            <td align="center">0.1.0</td>
            <td align="center">0.1.1</td>
            <td align="center">0.1.1</td>
        </tr>
        <tr>
            <td>Optional timestamp</td>
            <td align="center">0.1.1</td>
            <td align="center">0.1.1</td>
            <td align="center">0.1.1</td>
        </tr>
    </tbody>
</table>
