/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshoshujiiichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.dokuji.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.core.dokuji.ShujiiJokyo;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoshujiiichiran.IkenshoShujiiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ShujiiIryokikanShujiiIchiranhyoReportSource;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 主治医医療機関・主治医一覧表ボディEditorです。
 *
 * @reamsid_L DBE-0260-020 zuotao
 */
class IkenshoShujiiIchiranBodyEditor implements IkenshoShujiiIchiranEditor {

    private static final int 数値_7 = 7;
    private static final int 数値_3 = 3;
    private final IkenshoShujiiIchiranRelateEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IkenshoShujiiIchiranItem}
     */
    protected IkenshoShujiiIchiranBodyEditor(IkenshoShujiiIchiranRelateEntity item) {
        this.item = item;
    }

    @Override
    public ShujiiIryokikanShujiiIchiranhyoReportSource edit(ShujiiIryokikanShujiiIchiranhyoReportSource source) {
        return editBody(source);
    }

    private ShujiiIryokikanShujiiIchiranhyoReportSource editBody(ShujiiIryokikanShujiiIchiranhyoReportSource source) {

        source.cityCode = item.getShichosonCode();
        source.cityName = item.getShichosonMeisho();
        source.listIchiranhyoLower1_1 = item.getIryoKikanMeisho();
        source.listIchiranhyoLower1_2 = item.getDaihyoshaName() == null ? RString.EMPTY : item.getDaihyoshaName().value();
        source.listIchiranhyoLower1_3 = item.getJusho();
        source.listIchiranhyoLower2_1 = item.getShujiiName() == null ? RString.EMPTY : item.getShujiiName().value();
        source.listIchiranhyoLower2_2 = item.getShinryokaName()== null ? RString.EMPTY : item.getShinryokaName();
        source.listIchiranhyoUpper_1 = item.getIryokikanCode();
        source.listIchiranhyoUpper_2 = item.getIryoKikanMeishoKana();
        source.listIchiranhyoUpper_3 = item.getDaihyoshaNameKana();
        RString yubinNo = item.getYubinNo() == null ? RString.EMPTY : item.getYubinNo().value();
        if (RString.isNullOrEmpty(yubinNo)
                || item.getYubinNo().value().length() != 数値_7) {
            source.listIchiranhyoUpper_4 = yubinNo;
        } else {
            RStringBuilder yubinBango = new RStringBuilder();
            yubinBango.append(yubinNo.substring(0, 数値_3));
            yubinBango.append(new RString("-"));
            yubinBango.append(yubinBango.append(yubinNo.substring(数値_3)));
            source.listIchiranhyoUpper_4 = yubinBango.toRString();
        }
        source.listIchiranhyoUpper_5 = item.getTelNo() == null ? RString.EMPTY : item.getTelNo().value();
        source.listIchiranhyoUpper_7 = item.getShujiiCode();
        source.listIchiranhyoUpper_8 = item.getShujiiKana() == null ? RString.EMPTY : item.getShujiiKana().value();
        source.listIchiranhyoUpper_9 = item.getSeibetsu() == null ? RString.EMPTY
                : Gender.toValue(item.getSeibetsu().value()).getName().getShortJapanese();
        source.listIchiranhyoUpper_6 = IryoKikanJokyo.toValue(item.isIryokikanJokyoFlag()).get名称();
        source.listIchiranhyoUpper_10 = ShujiiJokyo.toValue(item.isShujiiJokyoFlag()).get名称();
        return source;
    }
}
