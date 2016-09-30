/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.ippangenbutsu;

import jp.co.ndensan.reams.db.dbu.definition.message.DbuInformationMessages;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippangenbutsu.JigyoHokokuGeppoIppanGenbutsuProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.JigyoHokokuIppanGenbutsuRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.KyufuJissekiKonkyoEUCEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.KyufuJissekiKonkyoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.shorikekkakakuninlist.ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.uz.uza.batch.api.BatchInfo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業状況報告統計情報ビジネスのクラスです
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
@Getter
@Setter
public class JigyoHokokuIppanGenbutsuBusiness {

    private JigyoHokokuGeppoIppanGenbutsuProcessParamter processParameter;
    private static final int INDEX = 8;

    /**
     * コンストラクタです。
     *
     * @param processParameter processParameter
     */
    public JigyoHokokuIppanGenbutsuBusiness(JigyoHokokuGeppoIppanGenbutsuProcessParamter processParameter) {
        this.processParameter = processParameter;
    }

    /**
     * KyufuJissekiKonkyoEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 給付集計区分 給付集計区分
     * @param 集計番号 集計番号
     * @return KyufuJissekiKonkyoEUCEntity
     */
    public KyufuJissekiKonkyoEUCEntity set事業報告統計データ(KyufuJissekiKonkyoRelateEntity entity, RString 給付集計区分, RString 集計番号) {
        KyufuJissekiKonkyoEUCEntity eucEntity = new KyufuJissekiKonkyoEUCEntity();
        eucEntity.setデータ区分(RString.EMPTY);
        eucEntity.set集計区分(new RString("1"));
        if (new RString("1").equals(給付集計区分)) {
            eucEntity.set表番号(new RString("01"));
        } else if (new RString("2").equals(給付集計区分)) {
            eucEntity.set表番号(new RString("03"));
        }
        eucEntity.set集計番号(集計番号);
        eucEntity.set集計単位(new RString("1"));
        eucEntity.set縦番号(entity.getTateNo());
        eucEntity.set横番号(entity.getYokoNo());
        eucEntity.set入力識別番号(entity.getInputShikibetsuNo());
        eucEntity.set被保険者番号(entity.getHihokenshaNo());
        eucEntity.setサービス提供年月(entity.getServiceTeikyoYM());
        eucEntity.set給付実績区分コード(entity.getKyufuJissekiKubunCode());
        eucEntity.set事業者番号(entity.getJigyoshoNo());
        eucEntity.set整理番号(entity.getSeiriNo());
        eucEntity.set生年月日(entity.getBirthDate());
        eucEntity.set要介護状態区分コード(entity.getYoKaigoJotaiKubunCode());
        eucEntity.setサービス種類コード(entity.getServiceShuruiCode());
        eucEntity.setサービス分類(entity.getServiceBunruiCode());
        eucEntity.set資格区分(entity.getHihokenshaKubunCode());
        eucEntity.set市町村コード(entity.getShichosonCode());
        eucEntity.set旧市町村コード(entity.getKyuShichosonCode());
        return eucEntity;
    }

    /**
     * ShoriKekkaKakuninListEntityの設定クラスです。
     *
     * @param entity entity
     * @param 保険者番号 保険者番号
     * @param 保険者名 保険者名
     * @return ShoriKekkaKakuninListEntity
     */
    public ShoriKekkaKakuninListEntity set処理結果確認リストEntity(JigyoHokokuIppanGenbutsuRelateEntity entity, RString 保険者番号, RString 保険者名) {
        ShoriKekkaKakuninListEntity eucEntity = new ShoriKekkaKakuninListEntity();
        eucEntity.set作成日時(processParameter.get処理日時());
        eucEntity.set保険者番号(保険者番号);
        eucEntity.set保険者名(保険者名);
        eucEntity.set項目コード1(new RString("被保険者番号"));
        eucEntity.set項目コード2(RString.EMPTY);
        eucEntity.set項目コード3(RString.EMPTY);
        eucEntity.set項目コード4(RString.EMPTY);
        eucEntity.setプログラムID(processParameter.getバッチID());
        if (entity.getHihokenshaNo() != null) {
            eucEntity.set項目値1(entity.getHihokenshaNo().value());
        }
        eucEntity.set項目値2(RString.EMPTY);
        eucEntity.set項目値3(RString.EMPTY);
        eucEntity.set項目値4(RString.EMPTY);
        eucEntity.set内容1(processParameter.get集計年月());
        eucEntity.set処理名称(BatchInfo.getBatchName(SubGyomuCode.DBU介護統計報告, processParameter.getバッチID()));
        RString 内容2 = RString.EMPTY;
        if (new RString("DBUI00010").equals(entity.getErrorCode()) && !RString.isNullOrEmpty(processParameter.get処理日時())) {
            内容2 = new RString(DbuInformationMessages.対象旧市町村不明_集計年月月末.getMessage().replace(processParameter.get処理日時().
                    substring(0, INDEX).toString()).toString());
        } else if (new RString("DBUI00002").equals(entity.getErrorCode())) {
            内容2 = new RString(DbuInformationMessages.年齢算出失敗_65to75集計.getMessage().toString());
        }
        eucEntity.set内容2(内容2);
        return eucEntity;
    }

}
