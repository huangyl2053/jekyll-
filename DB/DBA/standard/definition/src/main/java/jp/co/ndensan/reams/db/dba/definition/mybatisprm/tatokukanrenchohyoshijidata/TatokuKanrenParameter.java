/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.tatokukanrenchohyoshijidata;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 他市町村住所地特例者関連帳票クラスのパラメータ
 *
 * @reamsid_L DBA-0380-020 houtianpeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public final class TatokuKanrenParameter {

    private final YubinNo 郵便番号;
    private final RString 文書番号;
    private final RString 住所;
    private final FlexibleDate 発行日;
    private final RString 役所名;
    private final RString 役所名敬称;
    private final RString 担当課名;
    private final RString 担当課名敬称;
    private final ShikibetsuCode 識別コード;
    private final RString 措置被保険者番号;
    private final FlexibleDate 異動日;
    private final RString 枝番;
    private final FlexibleDate 入所年月日;
    private final boolean 住所出力不要フラグ;

    /**
     * コンストラクタ
     *
     * @param 郵便番号 郵便番号
     * @param 文書番号 文書番号
     * @param 住所 住所
     * @param 発行日 発行日
     * @param 役所名 役所名
     * @param 役所名敬称 役所名敬称
     * @param 担当課名 担当課名
     * @param 担当課名敬称 担当課名敬称
     * @param 識別コード 識別コード
     * @param 措置被保険者番号 措置被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @param 入所年月日 入所年月日
     * @param 住所出力不要フラグ 住所出力不要フラグ
     */
    private TatokuKanrenParameter(
            YubinNo 郵便番号,
            RString 文書番号,
            RString 住所,
            FlexibleDate 発行日,
            RString 役所名,
            RString 役所名敬称,
            RString 担当課名,
            RString 担当課名敬称,
            ShikibetsuCode 識別コード,
            RString 措置被保険者番号,
            FlexibleDate 異動日,
            RString 枝番,
            FlexibleDate 入所年月日,
            boolean 住所出力不要フラグ
    ) {
        this.郵便番号 = 郵便番号;
        this.文書番号 = 文書番号;
        this.住所 = 住所;
        this.発行日 = 発行日;
        this.役所名 = 役所名;
        this.役所名敬称 = 役所名敬称;
        this.担当課名 = 担当課名;
        this.担当課名敬称 = 担当課名敬称;
        this.識別コード = 識別コード;
        this.措置被保険者番号 = 措置被保険者番号;
        this.異動日 = 異動日;
        this.枝番 = 枝番;
        this.入所年月日 = 入所年月日;
        this.住所出力不要フラグ = 住所出力不要フラグ;
    }

    /**
     *
     * @param 郵便番号 郵便番号
     * @param 文書番号 文書番号
     * @param 住所 住所
     * @param 発行日 発行日
     * @param 役所名 役所名
     * @param 役所名敬称 役所名敬称
     * @param 担当課名 担当課名
     * @param 担当課名敬称 担当課名敬称
     * @param 識別コード 識別コード
     * @param 措置被保険者番号 措置被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @param 入所年月日 入所年月日
     * @param 住所出力不要フラグ 住所出力不要フラグ
     * @return createParam_TatokuKanren
     */
    public static TatokuKanrenParameter createParam_TatokuKanren(
            YubinNo 郵便番号,
            RString 文書番号,
            RString 住所,
            FlexibleDate 発行日,
            RString 役所名,
            RString 役所名敬称,
            RString 担当課名,
            RString 担当課名敬称,
            ShikibetsuCode 識別コード,
            RString 措置被保険者番号,
            FlexibleDate 異動日,
            RString 枝番,
            FlexibleDate 入所年月日,
            boolean 住所出力不要フラグ
    ) {
        return new TatokuKanrenParameter(
                郵便番号,
                文書番号,
                住所,
                発行日,
                役所名,
                役所名敬称,
                担当課名,
                担当課名敬称,
                識別コード,
                措置被保険者番号,
                異動日,
                枝番,
                入所年月日,
                住所出力不要フラグ
        );
    }
}
