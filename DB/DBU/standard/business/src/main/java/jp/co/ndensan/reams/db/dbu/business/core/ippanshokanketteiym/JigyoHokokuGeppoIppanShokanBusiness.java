/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.ippanshokanketteiym;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym.JigyouHoukokuTokeiEUCEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym.JyukyushaJohoKonkyoCSVRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import lombok.Getter;
import lombok.Setter;

/**
 * 根拠CSVビジネスのクラスです
 *
 * @reamsid_L DBU-5550-030 suguangjun
 */
@Getter
@Setter
public class JigyoHokokuGeppoIppanShokanBusiness {

    /**
     * JigyouHoukokuTokeiEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @return JigyouHoukokuTokeiEUCEntity
     */
    public JigyouHoukokuTokeiEUCEntity set統計明細CSVデータ(JyukyushaJohoKonkyoCSVRelateEntity entity) {
        JigyouHoukokuTokeiEUCEntity eucEntity = new JigyouHoukokuTokeiEUCEntity();
        getアクセスログ(entity.getHihokenshaNo().value());
        eucEntity.setデータ区分(entity.getDataTypeKubun());
        eucEntity.set集計区分(entity.getShukeiKubun());
        eucEntity.set表番号(entity.getHyouNo());
        eucEntity.set集計番号(entity.getShukeiNo());
        eucEntity.set集計単位(entity.getShukeiTani());
        eucEntity.set縦番号(entity.getTateNo());
        eucEntity.set横番号(entity.getYokoNo());
        eucEntity.set入力識別番号(entity.getInputShikibetsuNo());
        eucEntity.set被保険者番号(entity.getHihokenshaNo());
        eucEntity.setサービス提供年月(entity.getServiceTeikyoYM());
        eucEntity.set給付実績区分コード(entity.getKyufuJissekiKubunCode());
        eucEntity.set事業者番号(entity.getJigyoshoNo());
        eucEntity.set整理番号(entity.getSeiriNo());
        eucEntity.set生年月日(entity.getUmareYMD());
        eucEntity.set要介護状態区分コード(entity.getYoKaigoJotaiKubunCode());
        eucEntity.setサービス種類コード(entity.getServiceShuruiCode());
        eucEntity.setサービス分類(entity.getServiceBunrruicode());
        eucEntity.set資格区分(entity.getShikakuKubun());
        eucEntity.set市町村コード(entity.getShichosonCode());
        eucEntity.set旧市町村コード(entity.getKyuShichosonCode());
        return eucEntity;
    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void getアクセスログ(RString 被保険者番号) {
        AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, toPersonalData(被保険者番号));
    }

    private PersonalData toPersonalData(RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
