/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkokuhorenjukyusha;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト 国保連受給者情報のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-3104-020 yaodongsheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKokuhorenJukyushaProcessParameter implements IBatchProcessParameter {

    private RString 帳票ID;
    private Long 出力順ID;
    private RString 出力項目ID;
    private boolean is項目名付加;
    private boolean is連番付加;
    private boolean is日付編集;
    private RString 保険者コード;
    private RString 日付抽出区分;
    private RString 処理対象年月From;
    private RString 処理対象年月To;
    private RString 異動年月From;
    private RString 異動年月To;
    private boolean is各異動月の最新のみ;
    private List<RString> 異動区分s;
    private List<RString> みなし要介護区分s;
    private RString 事業者番号;
    private List<Boolean> 公費負担上限額減額s;
    private List<RString> 利用者負担区分s;
    private List<RString> 特定入所者サービス区分s;
    private boolean is削除含める;

    /**
     * コンストラクタです。
     *
     * @param 帳票ID 帳票ID
     * @param 出力順ID 出力順ID
     * @param 出力項目ID 出力項目ID
     * @param is項目名付加 is項目名付加
     * @param is連番付加 is連番付加
     * @param is日付編集 is日付編集
     * @param 保険者コード 保険者コード
     * @param 日付抽出区分 日付抽出区分
     * @param 処理対象年月From 処理対象年月From
     * @param 処理対象年月To 処理対象年月To
     * @param 異動年月From 異動年月From
     * @param 異動年月To 異動年月To
     * @param is各異動月の最新のみ is各異動月の最新のみ
     * @param 異動区分s 異動区分s
     * @param みなし要介護区分s みなし要介護区分s
     * @param 事業者番号 事業者番号
     * @param 公費負担上限額減額s 公費負担上限額減額s
     * @param 利用者負担区分s 利用者負担区分s
     * @param 特定入所者サービス区分s 特定入所者サービス区分s
     * @param is削除含める is削除含める
     */
    public HanyoListKokuhorenJukyushaProcessParameter(RString 帳票ID,
            Long 出力順ID,
            RString 出力項目ID,
            boolean is項目名付加,
            boolean is連番付加,
            boolean is日付編集,
            RString 保険者コード,
            RString 日付抽出区分,
            RString 処理対象年月From,
            RString 処理対象年月To,
            RString 異動年月From,
            RString 異動年月To,
            boolean is各異動月の最新のみ,
            List<RString> 異動区分s,
            List<RString> みなし要介護区分s,
            RString 事業者番号,
            List<Boolean> 公費負担上限額減額s,
            List<RString> 利用者負担区分s,
            List<RString> 特定入所者サービス区分s,
            boolean is削除含める) {
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
        this.出力項目ID = 出力項目ID;
        this.is項目名付加 = is項目名付加;
        this.is連番付加 = is連番付加;
        this.is日付編集 = is日付編集;
        this.保険者コード = 保険者コード;
        this.日付抽出区分 = 日付抽出区分;
        this.処理対象年月From = 処理対象年月From;
        this.処理対象年月To = 処理対象年月To;
        this.異動年月From = 異動年月From;
        this.異動年月To = 異動年月To;
        this.is各異動月の最新のみ = is各異動月の最新のみ;
        this.異動区分s = 異動区分s;
        this.みなし要介護区分s = みなし要介護区分s;
        this.事業者番号 = 事業者番号;
        this.公費負担上限額減額s = 公費負担上限額減額s;
        this.利用者負担区分s = 利用者負担区分s;
        this.特定入所者サービス区分s = 特定入所者サービス区分s;
        this.is削除含める = is削除含める;
    }
}
