/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710210;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jigyobunkogakugassanshikyukettei.JigyoBunKogakuGassanShikyuKetteiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_事業分高額合算支給決定情報のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-5060-030 duanzhanli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710210_HanyoListJigyoBunKogakuGassanShikyuKetteiParameter extends BatchParameterBase {

    @BatchParameter(key = "reportID", name = "帳票ID")
    private RString 帳票ID;
    @BatchParameter(key = "shutsuryokujunId", name = "出力順ID")
    private long 出力順ID;
    @BatchParameter(key = "shutsuryokujunkomokuId", name = "出力順項目ID")
    private RString 出力順項目ID;
    @BatchParameter(key = "komoukumei", name = "is項目名付加")
    private boolean is項目名付加;
    @BatchParameter(key = "renbanFuka", name = "is連番付加")
    private boolean is連番付加;
    @BatchParameter(key = "isdateedit", name = "is日付編集")
    private boolean is日付編集;
    @BatchParameter(key = "honkenshaCode", name = "保険者コード")
    private RString 保険者コード;
    @BatchParameter(key = "shikyuKubun", name = "支給区分")
    private RString 支給区分;
    @BatchParameter(key = "shiharaiHohoKubun", name = "支払方法区分")
    private RString 支払方法区分;
    @BatchParameter(key = "kikanCode", name = "金融機関コード")
    private RString 金融機関コード;
    @BatchParameter(key = "kikanmei", name = "金融機関名")
    private RString 金融機関名;
    @BatchParameter(key = "taishonendo", name = "対象年度")
    private RString 対象年度;

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public JigyoBunKogakuGassanShikyuKetteiProcessParameter toProcessParameter() {
        return new JigyoBunKogakuGassanShikyuKetteiProcessParameter(帳票ID,
                出力順ID,
                出力順項目ID,
                is項目名付加,
                is連番付加,
                is日付編集,
                保険者コード,
                支給区分,
                支払方法区分,
                金融機関コード,
                金融機関名,
                対象年度);
    }
}
