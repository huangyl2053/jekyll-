/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.jigyohokokugeppohokenkyufukogakugassan;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogakugassan.JigyoHokokuDataCsvRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokugeppohokenkyufukogakugassan.JigyoHokokuGeppoHokenEUCEntity;
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
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
@Getter
@Setter
public class JigyoHokokuGeppoHokenkyufuKogakuGassan {

    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");

    /**
     * コンストラクタです。
     *
     */
    public JigyoHokokuGeppoHokenkyufuKogakuGassan() {
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
        eucEntity.set表番号(entity.getHyouNo());
        eucEntity.set集計番号(entity.getShukeiNo());
        eucEntity.set集計単位(entity.getSyukeTani());
        eucEntity.set縦番号(entity.getTateNo());
        eucEntity.set横番号(entity.getYokoNo());
        eucEntity.set被保険者番号(entity.getHihokenshaNo().value());
        eucEntity.set対象年度(entity.getTaishoNendo());
        eucEntity.set保険者番号(entity.getHokenshaNo().value());
        eucEntity.set連絡票整理番号(entity.getShikyuSeiriNo());
        eucEntity.set履歴番号(entity.getRirekiNo());
        eucEntity.set自己負担額証明書整理番号(entity.getJikoFutanSeiriNo());
        eucEntity.set保険制度コード(entity.getHokenSeidoCode());
        eucEntity.set国保被保険者証記号(entity.getKokuho_HihokenshaShoKigo());
        if (entity.getKeisanKaishiYMD() != null && !entity.getKeisanKaishiYMD().isEmpty()) {
            eucEntity.set対象計算期間_開始(new RString(entity.getKeisanKaishiYMD().toString()));
        }
        if (entity.getKeisanShuryoYMD() != null && !entity.getKeisanShuryoYMD().isEmpty()) {
            eucEntity.set対象計算期間_終了(new RString(entity.getKeisanShuryoYMD().toString()));
        }
        if (entity.getShinseiYMD() != null && !entity.getShinseiYMD().isEmpty()) {
            eucEntity.set申請年月日(entity.getShinseiYMD().seireki().toDateString());
        }
        if (entity.getKetteiYMD() != null && !entity.getKetteiYMD().isEmpty()) {
            eucEntity.set決定年月日(entity.getKetteiYMD().seireki().toDateString());
        }
        eucEntity.set不支給の理由(entity.getFushikyuRiyu());
        eucEntity.set備考(entity.getBiko());
        eucEntity.set所得区分(entity.getShotokuKubun());
        eucEntity.set係る所得区分(entity.getOver70_ShotokuKubun());
        eucEntity.set警告(entity.getKeikoku());
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
