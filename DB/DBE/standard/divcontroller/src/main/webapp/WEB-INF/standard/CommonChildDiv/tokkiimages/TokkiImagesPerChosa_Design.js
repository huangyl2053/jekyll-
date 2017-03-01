var DBE;
(function (DBE) {
    (function (TokkiImagesPerChosa) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TokkiImagesPerChosa.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TokkiImagesPerChosa";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.TokkiImagesPerChosa.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.TokkiImagesPerChosa.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TokkiImagesPerChosa = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlTokkiJikoNos = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTokkiJikoNos"));
            };

            Controls.prototype.btnToDisplay = function () {
                return new UZA.Button(this.convFiledName("btnToDisplay"));
            };

            Controls.prototype.repTokkiJikos = function () {
                return new UZA.ControlRepeater(this.convFiledName("repTokkiJikos"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };

            Controls.prototype.btnSave = function () {
                return new UZA.Button(this.convFiledName("btnSave"));
            };
            return Controls;
        })();
        TokkiImagesPerChosa.Controls = Controls;
    })(DBE.TokkiImagesPerChosa || (DBE.TokkiImagesPerChosa = {}));
    var TokkiImagesPerChosa = DBE.TokkiImagesPerChosa;
})(DBE || (DBE = {}));
