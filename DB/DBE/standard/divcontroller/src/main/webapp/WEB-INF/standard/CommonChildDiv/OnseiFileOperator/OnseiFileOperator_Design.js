var DBE;
(function (DBE) {
    (function (OnseiFileOperator) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnDelete = function () {
                return "onClick_btnDelete";
            };
            return Events;
        })();
        OnseiFileOperator.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "OnseiFileOperator";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.OnseiFileOperator.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.OnseiFileOperator.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.OnseiFileOperator = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtNo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNo"));
            };

            Controls.prototype.txtInsDate = function () {
                return new UZA.TextBox(this.convFiledName("txtInsDate"));
            };

            Controls.prototype.btnDownload = function () {
                return new UZA.ButtonDownLoad(this.convFiledName("btnDownload"));
            };

            Controls.prototype.btnDelete = function () {
                return new UZA.Button(this.convFiledName("btnDelete"));
            };

            Controls.prototype.OnseiFileDeleted = function () {
                return new UZA.Panel(this.convFiledName("OnseiFileDeleted"));
            };

            Controls.prototype.icoOnseiFileDeleted = function () {
                return new UZA.Icon(this.convFiledName("icoOnseiFileDeleted"));
            };

            Controls.prototype.lblOnseiFileDeleted = function () {
                return new UZA.Label(this.convFiledName("lblOnseiFileDeleted"));
            };
            return Controls;
        })();
        OnseiFileOperator.Controls = Controls;
    })(DBE.OnseiFileOperator || (DBE.OnseiFileOperator = {}));
    var OnseiFileOperator = DBE.OnseiFileOperator;
})(DBE || (DBE = {}));
