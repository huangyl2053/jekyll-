/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.heikinriyogakutokeihyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.HeikinRiyoGakuTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.heikinriyogakutokeihyo.HeikinRiyoGakuTokeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 平均利用額統計表のEditorです。
 *
 * @reamsid_L DBC-3490-040 sunhaidi
 */
public class HeikinRiyoGakuTokeihyoEditor implements IHeikinRiyoGakuTokeihyoEditor {

    private final HeikinRiyoGakuTokeihyoEntity entity;
    private final RDateTime 処理時間;
    private static final int INDEX_16 = 16;
    private static final int INDEX_32 = 32;

    /**
     * コンストラクタです
     *
     * @param entity HeikinRiyoGakuTokeihyoEntity
     * @param 処理時間 RDateTime
     */
    public HeikinRiyoGakuTokeihyoEditor(HeikinRiyoGakuTokeihyoEntity entity, RDateTime 処理時間) {
        this.entity = entity;
        this.処理時間 = 処理時間;
    }

    /**
     * 平均利用額統計表の項目編集です
     *
     * @param source HeikinRiyoGakuTokeihyoReportSource
     * @return HeikinRiyoGakuTokeihyoReportSource
     */
    @Override
    public HeikinRiyoGakuTokeihyoReportSource edit(HeikinRiyoGakuTokeihyoReportSource source) {
        source.joken1 = entity.get条件1();
        source.joken2 = entity.get条件2();
        source.hokenshaNo = entity.get保険者番号();
        source.hokenshaName = entity.get保険者名();
        source.printTimeStamp = get処理時間(処理時間);
        source.List1_1 = entity.get人数明細_要支援１();
        source.List1_2 = entity.get人数明細_要支援２();
        source.List1_3 = entity.get人数明細_経過的要支援();
        source.List1_4 = entity.get人数明細_要介護１();
        source.List1_5 = entity.get人数明細_要介護２();
        source.List1_6 = entity.get人数明細_要介護３();
        source.List1_7 = entity.get人数明細_要介護４();
        source.List1_8 = entity.get人数明細_要介護５();
        source.List1_9 = entity.get人数明細_合計();
        source.List2_1 = entity.get費用総額明細_要支援１();
        source.List2_2 = entity.get費用総額明細_要支援２();
        source.List2_3 = entity.get費用総額明細_経過的要支援();
        source.List2_4 = entity.get費用総額明細_要介護１();
        source.List2_5 = entity.get費用総額明細_要介護２();
        source.List2_6 = entity.get費用総額明細_要介護３();
        source.List2_7 = entity.get費用総額明細_要介護４();
        source.List2_8 = entity.get費用総額明細_要介護５();
        source.List2_9 = entity.get費用総額明細_合計();
        source.List3_1 = entity.get平均額明細_要支援１();
        source.List3_2 = entity.get平均額明細_要支援２();
        source.List3_3 = entity.get平均額明細_経過的要支援();
        source.List3_4 = entity.get平均額明細_要介護１();
        source.List3_5 = entity.get平均額明細_要介護２();
        source.List3_6 = entity.get平均額明細_要介護３();
        source.List3_7 = entity.get平均額明細_要介護４();
        source.List3_8 = entity.get平均額明細_要介護５();
        source.List3_9 = entity.get平均額明細_合計();
        getサービス種類名称(source, entity.getサービス種類名称());
        source.ninzu6 = entity.get人数６();
        source.shotoku6 = entity.get所得段階６();
        source.hiyosogaku6 = entity.get費用総額６();
        source.heikingaku6 = entity.get平均額６();

        source.ninzu7 = entity.get人数７();
        source.shotoku7 = entity.get所得段階７();
        source.hiyosogaku7 = entity.get費用総額７();
        source.heikingaku7 = entity.get平均額７();
        source.ninzu8 = entity.get人数８();
        source.shotoku8 = entity.get所得段階８();
        source.hiyosogaku8 = entity.get費用総額８();
        source.heikingaku8 = entity.get平均額８();
        source.ninzu9 = entity.get人数９();
        source.shotoku9 = entity.get所得段階９();
        source.hiyosogaku9 = entity.get費用総額９();
        source.heikingaku9 = entity.get平均額９();
        source.ninzu10 = entity.get人数１０();
        source.shotoku10 = entity.get所得段階１０();
        source.hiyosogaku10 = entity.get費用総額１０();
        source.heikingaku10 = entity.get平均額１０();
        return source;
    }

    private void getサービス種類名称(HeikinRiyoGakuTokeihyoReportSource source, RString サービス種類名称) {
        if (RString.isNullOrEmpty(サービス種類名称)) {
            source.service1 = RString.EMPTY;
            source.service2 = RString.EMPTY;
            source.service3 = RString.EMPTY;
        }
        if (サービス種類名称.length() < INDEX_16) {
            source.service1 = サービス種類名称;
        } else if (サービス種類名称.length() < INDEX_32) {
            source.service1 = サービス種類名称.substring(0, INDEX_16);
            source.service2 = サービス種類名称.substring(INDEX_16);
        } else {
            source.service1 = サービス種類名称.substring(0, INDEX_16);
            source.service2 = サービス種類名称.substring(INDEX_16, INDEX_32);
            source.service3 = サービス種類名称.substring(INDEX_32);
        }
    }

    private RString get処理時間(RDateTime 処理時間) {
        if (処理時間 == null) {
            return RString.EMPTY;
        }
        RStringBuilder systemDateTime = new RStringBuilder();
        systemDateTime.append(処理時間.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(処理時間.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        return systemDateTime.toRString();
    }
}
