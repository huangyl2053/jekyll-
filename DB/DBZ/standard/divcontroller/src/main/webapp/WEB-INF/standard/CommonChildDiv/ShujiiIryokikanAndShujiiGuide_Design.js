var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanAndShujiiGuide) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShujiiIryokikanAndShujiiGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShujiiIryokikanAndShujiiGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShujiiIryokikanAndShujiiGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShujiiIryokikanAndShujiiGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShujiiIryokikanAndShujiiGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.KensakuJoken = function () {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            };

            Controls.prototype.txtHokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            };

            Controls.prototype.txtIryoKikanCodeFrom = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoKikanCodeFrom"));
            };

            Controls.prototype.txtIryoKikanCodeTo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoKikanCodeTo"));
            };

            Controls.prototype.txtIryoKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanName"));
            };

            Controls.prototype.txtShuijiiCodeFrom = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShuijiiCodeFrom"));
            };

            Controls.prototype.txtShujiiCodeTo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShujiiCodeTo"));
            };

            Controls.prototype.txtShujiiName = function () {
                return new UZA.TextBox(this.convFiledName("txtShujiiName"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.IryoKikanIchiran = function () {
                return new UZA.Panel(this.convFiledName("IryoKikanIchiran"));
            };

            Controls.prototype.dgIryoKikanIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgIryoKikanIchiran"));
            };

            Controls.prototype.ShujiiIchiran = function () {
                return new UZA.Panel(this.convFiledName("ShujiiIchiran"));
            };

            Controls.prototype.dgShujiiIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgShujiiIchiran"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };
            return Controls;
        })();
        ShujiiIryokikanAndShujiiGuide.Controls = Controls;
    })(DBZ.ShujiiIryokikanAndShujiiGuide || (DBZ.ShujiiIryokikanAndShujiiGuide = {}));
    var ShujiiIryokikanAndShujiiGuide = DBZ.ShujiiIryokikanAndShujiiGuide;
})(DBZ || (DBZ = {}));
