var DBZ;
(function (DBZ) {
    (function (SogoShokaiIryoHokenKanyuInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiIryoHokenKanyuInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiIryoHokenKanyuInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiIryoHokenKanyuInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiIryoHokenKanyuInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiIryoHokenKanyuInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgSogoShokaiHokenKanyuList = function () {
                return new UZA.DataGrid(this.convFiledName("dgSogoShokaiHokenKanyuList"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiIryoHokenKanyuInfo.Controls = Controls;
    })(DBZ.SogoShokaiIryoHokenKanyuInfo || (DBZ.SogoShokaiIryoHokenKanyuInfo = {}));
    var SogoShokaiIryoHokenKanyuInfo = DBZ.SogoShokaiIryoHokenKanyuInfo;
})(DBZ || (DBZ = {}));
