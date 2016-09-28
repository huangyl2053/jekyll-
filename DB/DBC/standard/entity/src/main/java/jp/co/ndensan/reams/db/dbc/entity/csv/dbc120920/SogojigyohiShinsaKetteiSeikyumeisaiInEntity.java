package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920;

/**
 * 総合事業費審査決定請求明細表情報取込の帳票出力対象データ
 *
 * @reamsid_L DBC-2500-012 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiShinsaKetteiSeikyumeisaiInEntity {

    private DbWT1611SinsaKetteiSeikyuMeisaiEntity 審査決定請求明細一時TBL;
    private DbWT1612SinsaKetteiSeikyuKogakuEntity 審査決定請求高額一時TBL;
    private DbWT1613SinsaKetteiSeikyuGokeiEntity 審査決定請求合計一時TBL;

}
