/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710210;

import java.util.List;
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

    private static final String KEY_REPORTID = "帳票ID";
    private static final String KEY_SHUTSURYOKUJUNID = "出力順ID";
    private static final String KEY_SHUTSURYOKUJUNKOMOKUID = "出力順項目ID";
    private static final String KEY_KOMOUKUMEI = "is項目名付加";
    private static final String KEY_RENBANFUKA = "is連番付加";
    private static final String KEY_ISDATEEDIT = "is日付編集";
    private static final String KEY_HONKENSHACODE = "保険者コード";
    private static final String KEY_SHIKYUKUBUN = "支給区分List";
    private static final String KEY_SHIHARAIHOHOKUBUN = "支払方法区分List";
    private static final String KEY_KIKANCODE = "金融機関コード";
    private static final String KEY_KIKANMEI = "金融機関名";
    private static final String KEY_TAISHONENDO = "対象年度";

    @BatchParameter(key = KEY_REPORTID, name = "帳票ID")
    private RString 帳票ID;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = "出力順ID")
    private long 出力順ID;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNKOMOKUID, name = "出力順項目ID")
    private RString 出力順項目ID;
    @BatchParameter(key = KEY_KOMOUKUMEI, name = "is項目名付加")
    private boolean is項目名付加;
    @BatchParameter(key = KEY_RENBANFUKA, name = "is連番付加")
    private boolean is連番付加;
    @BatchParameter(key = KEY_ISDATEEDIT, name = "is日付編集")
    private boolean is日付編集;
    @BatchParameter(key = KEY_HONKENSHACODE, name = "保険者コード")
    private RString 保険者コード;
    @BatchParameter(key = KEY_SHIKYUKUBUN, name = "支給区分")
    private List<RString> 支給区分List;
    @BatchParameter(key = KEY_SHIHARAIHOHOKUBUN, name = "支払方法区分")
    private List<RString> 支払方法区分List;
    @BatchParameter(key = KEY_KIKANCODE, name = "金融機関コード")
    private RString 金融機関コード;
    @BatchParameter(key = KEY_KIKANMEI, name = "金融機関名")
    private RString 金融機関名;
    @BatchParameter(key = KEY_TAISHONENDO, name = "対象年度")
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
                支給区分List,
                支払方法区分List,
                金融機関コード,
                金融機関名,
                対象年度);
    }
}
