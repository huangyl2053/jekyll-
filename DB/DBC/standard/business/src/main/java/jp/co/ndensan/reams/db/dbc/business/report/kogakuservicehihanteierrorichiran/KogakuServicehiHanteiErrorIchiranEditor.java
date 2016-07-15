/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehihanteierrorichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteierrorichiran.KogakuServicehiHanteiErrorIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteierrorlist.KogakuServicehiHanteiErrorListEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBCMN41002_高額介護サービス費判定エラーリスト Editor
 *
 * @reamsid_L DBC-2010-110 sunhui
 */
public class KogakuServicehiHanteiErrorIchiranEditor implements IKogakuServicehiHanteiErrorIchiranEditor {

    private final List<KogakuServicehiHanteiErrorListEntity> entityList;
    private final Association association;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param entityList List<KogakuServicehiHanteiErrorListEntity>
     * @param association Association
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     * @param 改頁項目List List<RString>
     */
    public KogakuServicehiHanteiErrorIchiranEditor(
            List<KogakuServicehiHanteiErrorListEntity> entityList,
            Association association,
            RString 並び順の１件目,
            RString 並び順の２件目,
            RString 並び順の３件目,
            RString 並び順の４件目,
            RString 並び順の５件目,
            List<RString> 改頁項目List) {
        this.entityList = entityList;
        this.association = association;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.改頁項目List = 改頁項目List;
    }

    /**
     * 帳票設計_DBCMN41002_高額介護サービス費判定エラーリストの項目編集です
     *
     * @param source KogakuServicehiHanteiErrorIchiranSource
     * @return KogakuServicehiHanteiErrorIchiranSource
     */
    @Override
    public KogakuServicehiHanteiErrorIchiranSource edit(KogakuServicehiHanteiErrorIchiranSource source) {

        RString 帳票作成年月日 = YMDHMS.now().getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 帳票作成時 = YMDHMS.now().getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成時)
                .concat(RString.HALF_SPACE).concat(SAKUSEI);
        if (entityList != null) {
            source.titleNengetsuKaishi = entityList.get(0).get審査年月From().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            source.titleNengetsu1 = entityList.get(0).get審査年月To().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            source.shichosonNo = entityList.get(0).get市町村コード();
            source.shichosonName = association.get市町村名();
            source.shutsuryokujun1 = 並び順の１件目;
            source.shutsuryokujun2 = 並び順の２件目;
            source.shutsuryokujun3 = 並び順の３件目;
            source.shutsuryokujun4 = 並び順の４件目;
            source.shutsuryokujun5 = 並び順の５件目;
            set出力順And改ページ(source);
            int i = 1;
            source.listHanteiError_1 = new RString(i++);
            source.listHanteiError_2 = entityList.get(0).get被保険者番号();
            source.listHanteiError_3 = new RString(entityList.get(0).getサービス提供年月().toString());
            source.listHanteiError_4 = entityList.get(0).get被保険者名();
            source.listHanteiError_5 = entityList.get(0).getエラーコード();
            source.listHanteiError_6 = entityList.get(0).get世帯コード();
            source.listHanteiError_7 = entityList.get(0).get世帯員識別コード();
            entityList.add(entityList.get(0));
        }
        return source;
    }

    private void set出力順And改ページ(KogakuServicehiHanteiErrorIchiranSource source) {
        source.shutsuryokujun1 = 並び順の１件目;
        source.shutsuryokujun2 = 並び順の２件目;
        source.shutsuryokujun3 = 並び順の３件目;
        source.shutsuryokujun4 = 並び順の４件目;
        source.shutsuryokujun5 = 並び順の５件目;
        if (null != 改頁項目List && !改頁項目List.isEmpty()) {
            if (改頁項目List.size() > NUM_0) {
                source.kaipage1 = 改頁項目List.get(NUM_0);
            }
            if (改頁項目List.size() > NUM_1) {
                source.kaipage2 = 改頁項目List.get(NUM_1);
            }
            if (改頁項目List.size() > NUM_2) {
                source.kaipage3 = 改頁項目List.get(NUM_2);
            }
            if (改頁項目List.size() > NUM_3) {
                source.kaipage4 = 改頁項目List.get(NUM_3);
            }
            if (改頁項目List.size() > NUM_4) {
                source.kaipage5 = 改頁項目List.get(NUM_4);
            }
        }
    }
}
