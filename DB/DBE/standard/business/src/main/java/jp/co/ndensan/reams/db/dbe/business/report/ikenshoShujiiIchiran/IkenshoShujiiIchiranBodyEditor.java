/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.dokuji.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.dokuji.ShujiiJokyo;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ShujiiIryokikanShujiiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 主治医医療機関・主治医一覧表ボディEditorです。
 */
class IkenshoShujiiIchiranBodyEditor implements IkenshoShujiiIchiranEditor {

    private static final int 数値_7 = 7;
    private static final int 数値_3 = 3;
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
        if (item.getListIchiranhyoUpper_4() == null
                || item.getListIchiranhyoUpper_4().length() != 数値_7) {
            source.listIchiranhyoUpper_4 = item.getListIchiranhyoUpper_4();
        } else {
            RStringBuilder yubinBango = new RStringBuilder();
            yubinBango.append(item.getListIchiranhyoUpper_4().substring(0, 数値_3));
            yubinBango.append(new RString("-"));
            yubinBango.append(yubinBango.append(item.getListIchiranhyoUpper_4().substring(数値_3)));
            source.listIchiranhyoUpper_4 = yubinBango.toRString();
        }
        source.listIchiranhyoUpper_5 = item.getListIchiranhyoUpper_5();
        source.listIchiranhyoUpper_7 = item.getListIchiranhyoUpper_7();
        source.listIchiranhyoUpper_8 = item.getListIchiranhyoUpper_8();
        source.listIchiranhyoUpper_9 = item.getListIchiranhyoUpper_9();
        source.listIchiranhyoUpper_6 = IryoKikanJokyo.toValue(item.isListIchiranhyoUpper_6()).get名称();
        source.listIchiranhyoUpper_10 = ShujiiJokyo.toValue(item.isListIchiranhyoUpper_10()).get名称();
        return source;
    }
}
