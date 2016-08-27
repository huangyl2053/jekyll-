/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hihokenshasho;

import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 被保険者証一括発行のMyBatisパラメータです。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class IkkatsuHakkoMybatisParameter implements IMyBatisParameter {

    private final RString 有効無効区分_有効 = YukoMukoKubun.有効.getコード();
    private final RString shutsuryokuJokenCode;
    private final RDateTime konkaiFromYMDHMS;
    private final FlexibleDate konkaiToYMD;
    private final RDateTime konkaiToYMDHMS;
    private final FlexibleDate konkaikijunYMD;
    private final RDateTime konkaikijunYMDHMS;
    private final FlexibleDate kofuYMD;
    private final ShinseishoKanriNo shinseishoKanriNo;
    private final FlexibleDate seinengappiToYMD;
    private final FlexibleDate seinengappiFromYMD;
    private final HihokenshaNo hihokenshaNo;
    private final ShikibetsuCode shikibetsuCode;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;
    private final FlexibleDate nenreiTotatsuYMD;
    private final RString orderby;
    private final boolean orderbyFlag;

    /**
     * コンストラクタです。<br/>
     *
     * @param 出力条件コード 出力条件コード
     * @param 今回の開始日時 今回の開始日時
     * @param 今回の終了日 今回の終了日
     * @param 今回の終了日時 今回の終了日時
     * @param 今回の基準日 今回の基準日
     * @param 今回の基準日時 今回の基準日時
     * @param 交付日 交付日
     * @param 申請書管理番号 申請書管理番号
     * @param 生年月日抽出開始日 生年月日抽出開始日
     * @param 生年月日抽出終了日 生年月日抽出終了日
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 識別対象PSM 識別対象PSM
     * @param 宛先PSM 宛先PSM
     * @param 年齢到達日 年齢到達日
     * @param orderby 出力順項目
     * @param orderbyFlag 出力順項目有り無し
     *
     */
    private IkkatsuHakkoMybatisParameter(RString 出力条件コード,
            RDateTime 今回の開始日時,
            FlexibleDate 今回の終了日,
            RDateTime 今回の終了日時,
            FlexibleDate 今回の基準日,
            RDateTime 今回の基準日時,
            FlexibleDate 交付日,
            ShinseishoKanriNo 申請書管理番号,
            FlexibleDate 生年月日抽出開始日,
            FlexibleDate 生年月日抽出終了日,
            HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            RString 識別対象PSM,
            RString 宛先PSM,
            FlexibleDate 年齢到達日,
            RString orderby,
            boolean orderbyFlag) {
        this.shutsuryokuJokenCode = 出力条件コード;
        this.konkaiFromYMDHMS = 今回の開始日時;
        this.konkaiToYMD = 今回の終了日;
        this.konkaiToYMDHMS = 今回の終了日時;
        this.konkaikijunYMD = 今回の基準日;
        this.konkaikijunYMDHMS = 今回の基準日時;
        this.kofuYMD = 交付日;
        this.shinseishoKanriNo = 申請書管理番号;
        this.seinengappiToYMD = 生年月日抽出開始日;
        this.seinengappiFromYMD = 生年月日抽出終了日;
        this.hihokenshaNo = 被保険者番号;
        this.shikibetsuCode = 識別コード;
        this.psmShikibetsuTaisho = 識別対象PSM;
        this.psmAtesaki = 宛先PSM;
        this.nenreiTotatsuYMD = 年齢到達日;
        this.orderby = orderby;
        this.orderbyFlag = orderbyFlag;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     ** @param 出力条件コード 出力条件コード
     * @param 今回の開始日時 今回の開始日時
     * @param 今回の終了日 今回の終了日
     * @param 今回の終了日時 今回の終了日時
     * @param 今回の基準日 今回の基準日
     * @param 今回の基準日時 今回の基準日時
     * @param 交付日 交付日
     * @param 申請書管理番号 申請書管理番号
     * @param 生年月日抽出開始日 生年月日抽出開始日
     * @param 生年月日抽出終了日 生年月日抽出終了日
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 識別対象PSM 識別対象PSM
     * @param 宛先PSM 宛先PSM
     * @param 年齢到達日 年齢到達日
     * @param orderby 出力順項目
     *
     * @return mybatisパラメータ
     */
    public static IkkatsuHakkoMybatisParameter createSelectByKeyParam(RString 出力条件コード,
            RDateTime 今回の開始日時,
            FlexibleDate 今回の終了日,
            RDateTime 今回の終了日時,
            FlexibleDate 今回の基準日,
            RDateTime 今回の基準日時,
            FlexibleDate 交付日,
            ShinseishoKanriNo 申請書管理番号,
            FlexibleDate 生年月日抽出開始日,
            FlexibleDate 生年月日抽出終了日,
            HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            RString 識別対象PSM,
            RString 宛先PSM,
            FlexibleDate 年齢到達日,
            RString orderby) {
        boolean flag = false;
        if (!RString.isNullOrEmpty(orderby)) {
            flag = true;
        }
        return new IkkatsuHakkoMybatisParameter(出力条件コード,
                今回の開始日時,
                今回の終了日,
                今回の終了日時,
                今回の基準日,
                今回の基準日時,
                交付日,
                申請書管理番号,
                生年月日抽出開始日,
                生年月日抽出終了日,
                被保険者番号,
                識別コード,
                識別対象PSM,
                宛先PSM,
                年齢到達日, orderby, flag);
    }
}
