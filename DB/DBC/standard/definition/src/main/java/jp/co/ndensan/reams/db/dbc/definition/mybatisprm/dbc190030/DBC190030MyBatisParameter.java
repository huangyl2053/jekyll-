/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc190030;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBC110065_基準収入額適用申請書_異動分作成のMyBatisパラメタークラスです。
 *
 * @reamsid_L DBC-4640-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBC190030MyBatisParameter implements IMyBatisParameter {

    private RString 抽出条件;
    private RString 抽出対象;
    private FlexibleYear 処理年度;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate 世帯員把握基準日;
    private FlexibleDate 世帯員把握基準日2;
    private RString 提出期限;
    private FlexibleDate 作成日;
    private Boolean 申請書出力フラグ;
    private Boolean お知らせ通知書出力フラグ;
    private Boolean 一覧表CSV出力フラグ;
    private RString 文書番号;
    private Long 帳票出力順ID;
    private LasdecCode 市町村コード;
    private RString 市町村名;
    private RString 出力順;
    private boolean 被保険者番号flag;

    /**
     * DBC180020ProcessParameterのコンストラクタです。
     *
     */
    public DBC190030MyBatisParameter() {
    }

    /**
     * DBC180020ProcessParameterのコンストラクタです。
     *
     * @param 抽出条件 RString
     * @param 抽出対象 RString
     * @param 処理年度 FlexibleYear
     * @param 被保険者番号 HihokenshaNo
     * @param 世帯員把握基準日 FlexibleDate
     * @param 世帯員把握基準日2 FlexibleDate
     * @param 提出期限 RString
     * @param 作成日 FlexibleDate
     * @param 申請書出力フラグ Boolean
     * @param お知らせ通知書出力フラグ Boolean
     * @param 一覧表CSV出力フラグ Boolean
     * @param 文書番号 RString
     * @param 帳票出力順ID Long
     * @param 市町村コード LasdecCode
     * @param 市町村名 RString
     * @param 被保険者番号flag boolean
     */
    public DBC190030MyBatisParameter(RString 抽出条件,
            RString 抽出対象,
            FlexibleYear 処理年度,
            HihokenshaNo 被保険者番号,
            FlexibleDate 世帯員把握基準日,
            FlexibleDate 世帯員把握基準日2,
            RString 提出期限,
            FlexibleDate 作成日,
            Boolean 申請書出力フラグ,
            Boolean お知らせ通知書出力フラグ,
            Boolean 一覧表CSV出力フラグ,
            RString 文書番号,
            Long 帳票出力順ID,
            LasdecCode 市町村コード,
            RString 市町村名,
            boolean 被保険者番号flag) {
        this.抽出条件 = 抽出条件;
        this.抽出対象 = 抽出対象;
        this.処理年度 = 処理年度;
        this.被保険者番号 = 被保険者番号;
        this.世帯員把握基準日 = 世帯員把握基準日;
        this.世帯員把握基準日2 = 世帯員把握基準日2;
        this.提出期限 = 提出期限;
        this.作成日 = 作成日;
        this.申請書出力フラグ = 申請書出力フラグ;
        this.お知らせ通知書出力フラグ = お知らせ通知書出力フラグ;
        this.一覧表CSV出力フラグ = 一覧表CSV出力フラグ;
        this.文書番号 = 文書番号;
        this.帳票出力順ID = 帳票出力順ID;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.被保険者番号flag = 被保険者番号flag;
    }

}
