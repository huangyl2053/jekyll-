/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe5910001;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ShujiiIryokikanShujiiIchiranhyoReportSource;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.SeibetsuCodeType;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関・主治医一覧表ボディEditorです。
 */
class IkenshoShujiiIchiranBodyEditor implements IkenshoShujiiIchiranEditor {

    private final IkenshoShujiiIchiranBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IkenshoShujiiIchiranItem}
     */
    protected IkenshoShujiiIchiranBodyEditor(IkenshoShujiiIchiranBodyItem item) {
        this.item = item;
    }

    @Override
    public ShujiiIryokikanShujiiIchiranhyoReportSource edit(ShujiiIryokikanShujiiIchiranhyoReportSource source) {
        return editBody(source);
    }
    
    private ShujiiIryokikanShujiiIchiranhyoReportSource editBody(ShujiiIryokikanShujiiIchiranhyoReportSource source) {
        source.listIchiranhyoLower1_1 = item.getListIchiranhyoLower1_1();
        source.listIchiranhyoLower1_2 = item.getListIchiranhyoLower1_2();
        source.listIchiranhyoLower1_3 = item.getListIchiranhyoLower1_3();
        source.listIchiranhyoLower2_1 = item.getListIchiranhyoLower2_1();
        source.listIchiranhyoLower2_2 = item.getListIchiranhyoLower2_2();
        source.listIchiranhyoUpper_1 = item.getListIchiranhyoUpper_1();
        source.listIchiranhyoUpper_2 = item.getListIchiranhyoUpper_2();
        source.listIchiranhyoUpper_3 = item.getListIchiranhyoUpper_3();
        // TODO 左涛 QA224　郵便番号編集の確認
        source.listIchiranhyoUpper_4 = item.getListIchiranhyoUpper_4();
        source.listIchiranhyoUpper_5 = item.getListIchiranhyoUpper_5();
        source.listIchiranhyoUpper_7 = item.getListIchiranhyoUpper_7();
        source.listIchiranhyoUpper_8 = item.getListIchiranhyoUpper_8();
        source.listIchiranhyoUpper_9 = SeibetsuCodeType.toValue(item.getListIchiranhyoUpper_9()).toRString();

        // TODO 左涛 QA224　医療機関状況ENUMの確認
        if (item.isListIchiranhyoUpper_6()) {
            source.listIchiranhyoUpper_6 = new RString("有効");
        } else if (!item.isListIchiranhyoUpper_6()) {
            source.listIchiranhyoUpper_6 = new RString("無効");
        }
        // TODO 左涛 QA224　主治医状況ENUMの確認
        if (item.isListIchiranhyoUpper_10()) {
            source.listIchiranhyoUpper_10 = new RString("有効");
        } else if (!item.isListIchiranhyoUpper_10()) {
            source.listIchiranhyoUpper_10 = new RString("無効");
        }
        return source;
    }
}
