/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.jigyohokokugeppohokenkyufukogaku;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogaku.JigyoHokokuDataCsvRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokugeppohokenkyufukogaku.JigyoHokokuGeppoHokenEUCEntity;
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
 * 事業状況報告情報ビジネスのクラスです
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
@Getter
@Setter
public class JigyoHokokuGeppoHokenkyufuKogaku {

    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");

    /**
     * コンストラクタです。
     *
     */
    public JigyoHokokuGeppoHokenkyufuKogaku() {
    }

    /**
     * コンストラクタです。
     *
     * @param entity 事業状況報告情報
     * @return JigyoHokokuGeppoHokenEUCEntity
     */
    public JigyoHokokuGeppoHokenEUCEntity setEUCEntity(JigyoHokokuDataCsvRelateEntity entity) {
        JigyoHokokuGeppoHokenEUCEntity eucEntity = new JigyoHokokuGeppoHokenEUCEntity();
        getアクセスログ(entity.getHihokenshaNo().value());
        eucEntity.setデータ区分(entity.getDataKubun());
        if (区分_1.equals(entity.getSyukeKubun())) {
            eucEntity.set集計区分(new RString("加算"));
        }
        if (区分_2.equals(entity.getSyukeKubun())) {
            eucEntity.set集計区分(new RString("減算"));
        }
        eucEntity.set表番号(RString.EMPTY);
        eucEntity.set集計番号(entity.getShukeiNo());
        eucEntity.set集計単位(entity.getSyukeTani());
        eucEntity.set縦番号(entity.getTateNo());
        eucEntity.set横番号(entity.getYokoNo());
        eucEntity.set被保険者番号(entity.getHihokenshaNo().value());
        eucEntity.setサービス提供年月(entity.getServiceTeikyoYM());
        eucEntity.set証記載保険者番号(entity.getShoKisaiHokenshaNo().value());
        eucEntity.set履歴番号(entity.getRirekiNo());
        eucEntity.set支給区分コード(entity.getShikyuKubunCode());
        eucEntity.set支給金額(entity.getShikyuKingaku());
        eucEntity.set支払済金額合計(entity.getShiharaiSumiKingakuGokei());
        eucEntity.set世帯集約番号(entity.getSetaiShuyakuNo());
        eucEntity.set様式区分(entity.getYousikiKubun());
        eucEntity.set世帯合算受給区分(entity.getSetaiGassanJyukyuuKubun());
        eucEntity.set備考1(entity.getBiko1());
        eucEntity.set備考2(entity.getBiko2());
        eucEntity.set備考3(entity.getBiko3());
        eucEntity.set備考4(entity.getBiko4());
        eucEntity.set備考5(entity.getBiko5());
        eucEntity.set入力識別番号(entity.getInputShikibetsuNo());
        eucEntity.set給付実績情報作成区分コード(entity.getKyufuSakuseiKubunCode());
        eucEntity.set給付実績区分コード(entity.getKyufuJissekiKubunCode());
        eucEntity.set公費１負担番号(entity.getKohi1FutanNo());
        eucEntity.set公費２負担番号(entity.getKohi2FutanNo());
        eucEntity.set公費３負担番号(entity.getKohi3FutanNo());
        eucEntity.set公費１支給額(entity.getKohi1Shikyugaku());
        eucEntity.set公費２支給額(entity.getKohi2Shikyugaku());
        eucEntity.set公費３支給額(entity.getKohi3Shikyugaku());
        eucEntity.set審査年月(entity.getShinsaYM());
        eucEntity.set被保険者区分コード(entity.getHihokennshaKubunCode());
        eucEntity.set広住特措置元市町村コード(entity.getShichosonCode());
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
