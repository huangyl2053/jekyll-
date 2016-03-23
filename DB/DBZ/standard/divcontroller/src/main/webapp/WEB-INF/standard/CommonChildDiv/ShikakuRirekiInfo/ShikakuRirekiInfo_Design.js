var DBZ;
(function (DBZ) {
    (function (ShikakuRirekiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgShikakuShutokuRireki = function () {
                return "onSelect_dgShikakuShutokuRireki";
            };

            Events.onSelectByDblClick_dgShikakuShutokuRireki = function () {
                return "onSelectByDblClick_dgShikakuShutokuRireki";
            };

            Events.onSelectByModifyButton_dgShikakuShutokuRireki = function () {
                return "onSelectByModifyButton_dgShikakuShutokuRireki";
            };

            Events.onSelectByDeleteButton_dgShikakuShutokuRireki = function () {
                return "onSelectByDeleteButton_dgShikakuShutokuRireki";
            };
            return Events;
        })();
        ShikakuRirekiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuRirekiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShikakuRirekiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShikakuRirekiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuRirekiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShikakuRirekiInfo = function () {
                return new UZA.DataGrid(this.convFiledName("dgShikakuRirekiInfo"));
            };

            Controls.prototype.BtnClose = function () {
                return new UZA.Button(this.convFiledName("BtnClose"));
            };
            return Controls;
        })();
        ShikakuRirekiInfo.Controls = Controls;
    })(DBZ.ShikakuRirekiInfo || (DBZ.ShikakuRirekiInfo = {}));
    var ShikakuRirekiInfo = DBZ.ShikakuRirekiInfo;
})(DBZ || (DBZ = {}));
