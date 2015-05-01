var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanAndShujiiInput) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShujiiIryokikanAndShujiiInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShujiiIryokikanAndShujiiInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShujiiIryokikanAndShujiiInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShujiiIryokikanAndShujiiInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShujiiIryokikanAndShujiiInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtIryoKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoKikanCode"));
            };

            Controls.prototype.btnIryokikanGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIryokikanGuide"));
            };

            Controls.prototype.txtIryoKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanName"));
            };

            Controls.prototype.btnShujiiRenrakuJiko = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShujiiRenrakuJiko"));
            };

            Controls.prototype.btnZenkaiIrokikanJoho = function () {
                return new UZA.Button(this.convFiledName("btnZenkaiIrokikanJoho"));
            };

            Controls.prototype.txtShujiiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShujiiCode"));
            };

            Controls.prototype.btnShujiiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShujiiGuide"));
            };

            Controls.prototype.txtShujiiName = function () {
                return new UZA.TextBox(this.convFiledName("txtShujiiName"));
            };

            Controls.prototype.chkShiteii = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShiteii"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };
            return Controls;
        })();
        ShujiiIryokikanAndShujiiInput.Controls = Controls;
    })(DBZ.ShujiiIryokikanAndShujiiInput || (DBZ.ShujiiIryokikanAndShujiiInput = {}));
    var ShujiiIryokikanAndShujiiInput = DBZ.ShujiiIryokikanAndShujiiInput;
})(DBZ || (DBZ = {}));
