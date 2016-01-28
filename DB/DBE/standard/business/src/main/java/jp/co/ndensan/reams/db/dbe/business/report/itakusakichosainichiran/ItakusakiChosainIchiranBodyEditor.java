/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.Sikaku;
import jp.co.ndensan.reams.db.dbe.entity.report.itakusakichosainichiran.ItakusakiChosainIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査委託先・調査員一覧表ボディEditorです。
 */
public class ItakusakiChosainIchiranBodyEditor implements ItakusakiChosainIchiranEditor {

    private static final RString 有効_VALUE = new RString("有効");
    private static final RString 無効_VALUE = new RString("無効");
    private final ItakusakiChosainIchiranBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ItakusakiChosainIchiranBodyItem}
     */
    protected ItakusakiChosainIchiranBodyEditor(ItakusakiChosainIchiranBodyItem item) {
        this.item = item;
    }

    @Override
    public ItakusakiChosainIchiranReportSource edit(ItakusakiChosainIchiranReportSource source) {
        return editBody(source);
    }

    private ItakusakiChosainIchiranReportSource editBody(ItakusakiChosainIchiranReportSource source) {
        source.listIchiranhyoUpper_1 = item.getShujiiIryokikanCode();
        source.listIchiranhyoUpper_2 = item.getIryoKikanMeishoKana();
        source.listIchiranhyoUpper_3 = item.getDaihyoshaNameKana();
        source.listIchiranhyoUpper_4 = item.getYubinNo();
        source.listIchiranhyoUpper_5 = item.getTelNo();
        if (item.isJokyoFlag()) {
            source.listIchiranhyoUpper_6 = 有効_VALUE;
        } else if (!item.isJokyoFlag()) {
            source.listIchiranhyoUpper_6 = 無効_VALUE;
        }
        source.listIchiranhyoUpper_7 = item.getShujiiCode();
        source.listIchiranhyoUpper_8 = item.getShujiiKana();
        source.listIchiranhyoUpper_9 = item.getChosainShikaku();
        if (item.getChosainShikaku() != null) {
            source.listIchiranhyoUpper_10 = Sikaku.toValue(item.getChosainShikaku()).get名称();
        }
        if (item.isShujiiJokyoFlag()) {
            source.listIchiranhyoUpper_11 = 有効_VALUE;
        } else if (!item.isShujiiJokyoFlag()) {
            source.listIchiranhyoUpper_11 = 無効_VALUE;
        }
        source.listIchiranhyoLower1_1 = item.getIryoKikanMeisho();
        source.listIchiranhyoLower1_2 = item.getDaihyoshaName();
        source.listIchiranhyoLower1_3 = item.getJusho();
        source.listIchiranhyoLower2_1 = item.getShujiiName();
        if (!item.getSeibetsu().trim().isEmpty()) {
            source.listIchiranhyoLower2_2 = Seibetsu.toValue(item.getSeibetsu()).get名称();
        }
        source.listIchiranhyoLower2_3 = item.getShinryokaName();
        return source;
    }

}
