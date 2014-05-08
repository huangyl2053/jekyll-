/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosahyo.INinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KihonchosaResultInputCom;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.TextBoxUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * KihonchosaResultInputComを編集するのに用います。
 *
 * @author N3327 三浦 凌
 */
public class KihonchosaResultInputComUtil {

    private KihonchosaResultInputComUtil() {
    }

    /**
     * INinteichosaItemのlistをKihonchosaResultInputComのlistへ変換します。
     *
     * @param items list of INinteichosaItem
     * @return list of KihonchosaResultInputComのlist
     * @deprecated このメソッドは正常動作しません(複合コントロールのインスタンス生成ができないため…)。使用禁止です。
     */
    @Deprecated
    public static List<KihonchosaResultInputCom> toListOfKihonchosaResultInputCom(List<INinteichosaItem> items) {
        List<KihonchosaResultInputCom> controls = new ArrayList<>();
        NinteichosaItemNo before = new NinteichosaItemNo(RString.EMPTY);
        for (INinteichosaItem item : items) {
            RString itemNameText = _composeItemNameFrom(item);

            RString itemNoText = RString.EMPTY;
            NinteichosaItemNo itemNo = item.get調査項目番号();
            if (!itemNo.equals(before)) {
                before = itemNo;
                itemNoText = itemNo.value();
            }
            KihonchosaResultInputCom control
                    = _createKihonchosaResultInputCom(itemNoText, itemNameText);
            controls.add(control);
        }
        return controls;
    }

    /**
     * 新しいKihonchosaResultInputComを生成します。
     *
     * @param itemNo 項目番号
     * @param itemName 項目名
     * @return 指定の番号、項目名を設定したKihonchosaResultInputCom
     * @deprecated KihonchosaResultInputComのインスタンスを生成するとエラーが発生するため、使用禁止です。
     */
    @Deprecated
    private static KihonchosaResultInputCom _createKihonchosaResultInputCom(RString itemNo, RString itemName) {
        KihonchosaResultInputCom control = new KihonchosaResultInputCom();
        control.setLblItemName(_toLabel(itemNo));
        control.setLblItemName(_toLabel(itemName));
        control.setTxtAnswer(_createNewTextBox());
        return null;
    }

    private static Label _toLabel(RString text) {
        Label label = new Label();
        label.setText(text);
        label.setWrap(true);
        return label;
    }

    private static TextBox _createNewTextBox() {
        return new TextBoxUtil.TextBoxBuilder().wrap(true).build();
    }

    private static RString _composeItemNameFrom(INinteichosaItem item) {
        return _hasNoSubGroup(item)
                ? _itemNameOf(item)
                : _composeItemName_withSubGroupName(item);
    }

    private static RString _itemNameOf(INinteichosaItem item) {
        return item.get表示名称();
    }

    private static RString _composeItemName_withSubGroupName(INinteichosaItem item) {
        RString groupName = _subGroupShortNameOf(item);
        return item.get調査項目サブグループ().isMultiSelectable()
                ? new RStringBuilder(groupName).append(_putInParenthesis(_itemNameOf(item))).toRString()
                : groupName;
    }

    private static boolean _hasNoSubGroup(INinteichosaItem item) {
        return item.get調査項目サブグループ() == NinteichosaItemSubGroup.なし;
    }

    private static RString _subGroupShortNameOf(INinteichosaItem item) {
        return item.get調査項目サブグループ().getShortName();
    }

    private static RString _putInParenthesis(RString text) {
        return new RStringBuilder("(").append(text).append(")").toRString();
    }

}
