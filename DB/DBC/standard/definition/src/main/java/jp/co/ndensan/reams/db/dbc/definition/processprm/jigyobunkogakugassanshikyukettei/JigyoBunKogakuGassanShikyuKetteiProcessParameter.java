/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.jigyobunkogakugassanshikyukettei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_事業分高額合算支給決定情報のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-5060-030 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoBunKogakuGassanShikyuKetteiProcessParameter implements IBatchProcessParameter {

    private final RString 帳票ID;
    private final long 出力順ID;
    private final RString 出力順項目ID;
    private final boolean is項目名付加;
    private final boolean is連番付加;
    private final boolean is日付編集;
    private final RString 保険者コード;
    private final List<RString> 支給区分List;
    private final List<RString> 支払方法区分List;
    private final RString 金融機関コード;
    private final RString 金融機関名;
    private final RString 対象年度;

    /**
     * コンストラクタです。
     *
     * @param 帳票ID 帳票ID
     * @param 出力順ID 出力順ID
     * @param 出力順項目ID 出力順項目ID
     * @param is項目名付加 is項目名付加
     * @param is連番付加 is連番付加
     * @param is日付編集 is日付編集
     * @param 保険者コード 保険者コード
     * @param 支給区分List 支給区分List
     * @param 支払方法区分List 支払方法区分List
     * @param 金融機関コード 金融機関コード
     * @param 金融機関名 金融機関名
     * @param 対象年度 対象年度
     */
    public JigyoBunKogakuGassanShikyuKetteiProcessParameter(RString 帳票ID,
            long 出力順ID,
            RString 出力順項目ID,
            boolean is項目名付加,
            boolean is連番付加,
            boolean is日付編集,
            RString 保険者コード,
            List<RString> 支給区分List,
            List<RString> 支払方法区分List,
            RString 金融機関コード,
            RString 金融機関名,
            RString 対象年度) {
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
        this.出力順項目ID = 出力順項目ID;
        this.is項目名付加 = is項目名付加;
        this.is連番付加 = is連番付加;
        this.is日付編集 = is日付編集;
        this.保険者コード = 保険者コード;
        this.支給区分List = 支給区分List;
        this.支払方法区分List = 支払方法区分List;
        this.金融機関コード = 金融機関コード;
        this.金融機関名 = 金融機関名;
        this.対象年度 = 対象年度;
    }
}
