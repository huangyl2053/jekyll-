/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanjuryoininkeiyakusha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 契約事業者一覧リスト取得のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-2130-030 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanJuryoininKeiyakushaListParameter {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 契約申請日FROM;
    private FlexibleDate 契約申請日TO;
    private FlexibleDate 契約決定日FROM;
    private FlexibleDate 契約決定日TO;
    private RString 契約事業者番号;
    private RString 契約サービス種類;
    private FlexibleYear 契約年度;
    private RString 契約番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 契約申請日FROM 契約申請日FROM
     * @param 契約申請日TO 契約申請日TO
     * @param 契約決定日FROM 契約決定日FROM
     * @param 契約決定日TO 契約決定日TO
     * @param 契約事業者番号 契約事業者番号
     * @param 契約サービス種類 契約サービス種類
     * @param 契約年度 契約年度
     * @param 契約番号 契約番号
     */
    protected ShokanJuryoininKeiyakushaListParameter(HihokenshaNo 被保険者番号,
            FlexibleDate 契約申請日FROM,
            FlexibleDate 契約申請日TO,
            FlexibleDate 契約決定日FROM,
            FlexibleDate 契約決定日TO,
            RString 契約事業者番号,
            RString 契約サービス種類,
            FlexibleYear 契約年度,
            RString 契約番号) {
        this.被保険者番号 = 被保険者番号;
        this.契約申請日FROM = 契約申請日FROM;
        this.契約申請日TO = 契約申請日TO;
        this.契約決定日FROM = 契約決定日FROM;
        this.契約決定日TO = 契約決定日TO;
        this.契約事業者番号 = 契約事業者番号;
        this.契約サービス種類 = 契約サービス種類;
        this.契約年度 = 契約年度;
        this.契約番号 = 契約番号;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 契約申請日FROM 契約申請日FROM
     * @param 契約申請日TO 契約申請日TO
     * @param 契約決定日FROM 契約決定日FROM
     * @param 契約決定日TO 契約決定日TO
     * @param 契約事業者番号 契約事業者番号
     * @param 契約サービス種類 契約サービス種類
     * @param 契約年度 契約年度
     * @param 契約番号 契約番号
     * @return ShokanJuryoininKeiyakushaListParameter
     */
    public static ShokanJuryoininKeiyakushaListParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号,
            FlexibleDate 契約申請日FROM,
            FlexibleDate 契約申請日TO,
            FlexibleDate 契約決定日FROM,
            FlexibleDate 契約決定日TO,
            RString 契約事業者番号,
            RString 契約サービス種類,
            FlexibleYear 契約年度,
            RString 契約番号) {

        return new ShokanJuryoininKeiyakushaListParameter(被保険者番号, 契約申請日FROM, 契約申請日TO, 契約決定日FROM,
                契約決定日TO, 契約事業者番号, 契約サービス種類, 契約年度, 契約番号);
    }

}
