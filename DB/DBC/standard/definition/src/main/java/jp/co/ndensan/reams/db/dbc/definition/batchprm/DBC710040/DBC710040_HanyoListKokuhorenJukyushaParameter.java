/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710040;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkokuhorenjukyusha.HanyoListKokuhorenJukyushaProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト 国保連受給者情報のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-3104-010 yaodongsheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710040_HanyoListKokuhorenJukyushaParameter extends BatchParameterBase {

    private static final String CHOHYOID = "chohyoId";
    private static final String SHUTSURYOKUJUNID = "shutsuryokujunId";
    private static final String SHUTSURYOKUKOMOKUID = "shutsuryokukomokuId";
    private static final String KOMOKUMEFUKA = "komokumeFuka";
    private static final String RENBANFUKA = "renbanFuka";
    private static final String HITSUKEHENSHU = "hitsukeHenshu";
    private static final String HOKENSHAKODO = "hokenshaKodo";
    private static final String HITSUKECHUSHUTSUKUBUN = "hitsukeChushutsuKubun";
    private static final String SHORITAISHONENGETSUFROM = "shoriTaishoNengetsuFrom";
    private static final String SHORITAISHONENGETSUTO = "shoriTaishoNengetsuTo";
    private static final String IDONENGETSUFROM = "idoNengetsuFrom";
    private static final String IDONENGETSUTO = "idoNengetsuTo";
    private static final String KAKUIDOZUKINOSAISHINNOMI = "kakuidozukinoSaishinNomi";
    private static final String IDOKUBUN = "idoKubun";
    private static final String MINASHIYOKAIGOKUBUN = "minashiYokaigoKubun";
    private static final String JIGYOSHABANGGO = "jigyoshaBanggo";
    private static final String KOHIFUTANJYOGENGAKUGENGAKU = "kohiFutanJyogengakuGengaku";
    private static final String RIYOSHAFUTANKUBUN = "riyoshaFutanKubun";
    private static final String TOKUTEINYUSHOSHASABISUKUBUN = "tokuteiNyushoshaSabisuKubun";
    private static final String SAKUJYOMERU = "sakujyoMeru";

    @BatchParameter(key = CHOHYOID, name = "帳票ID")
    private RString chohyoId;
    @BatchParameter(key = SHUTSURYOKUJUNID, name = "出力順ID")
    private Long shutsuryokujunId;
    @BatchParameter(key = SHUTSURYOKUKOMOKUID, name = "出力項目ID")
    private RString shutsuryokukomokuId;
    @BatchParameter(key = KOMOKUMEFUKA, name = "項目名付加")
    private boolean komokumeFuka;
    @BatchParameter(key = RENBANFUKA, name = "連番付加")
    private boolean renbanFuka;
    @BatchParameter(key = HITSUKEHENSHU, name = "日付編集")
    private boolean hitsukeHenshu;
    @BatchParameter(key = HOKENSHAKODO, name = "保険者コード")
    private RString hokenshaKodo;
    @BatchParameter(key = HITSUKECHUSHUTSUKUBUN, name = "日付抽出区分")
    private RString hitsukeChushutsuKubun;
    @BatchParameter(key = SHORITAISHONENGETSUFROM, name = "処理対象年月From")
    private RString shoriTaishoNengetsuFrom;
    @BatchParameter(key = SHORITAISHONENGETSUTO, name = "処理対象年月To")
    private RString shoriTaishoNengetsuTo;
    @BatchParameter(key = IDONENGETSUFROM, name = "異動年月From")
    private RString idoNengetsuFrom;
    @BatchParameter(key = IDONENGETSUTO, name = "異動年月To")
    private RString idoNengetsuTo;
    @BatchParameter(key = KAKUIDOZUKINOSAISHINNOMI, name = "各異動月の最新のみ")
    private boolean kakuidozukinoSaishinNomi;
    @BatchParameter(key = IDOKUBUN, name = "異動区分s")
    private List<RString> idoKubun;
    @BatchParameter(key = MINASHIYOKAIGOKUBUN, name = "みなし要介護区分s")
    private List<RString> minashiYokaigoKubun;
    @BatchParameter(key = JIGYOSHABANGGO, name = "事業者番号")
    private RString jigyoshaBanggo;
    @BatchParameter(key = KOHIFUTANJYOGENGAKUGENGAKU, name = "公費負担上限額減額s")
    private List<Boolean> kohiFutanJyogengakuGengaku;
    @BatchParameter(key = RIYOSHAFUTANKUBUN, name = "利用者負担区分s")
    private List<RString> riyoshaFutanKubun;
    @BatchParameter(key = TOKUTEINYUSHOSHASABISUKUBUN, name = "特定入所者サービス区分s")
    private List<RString> tokuteiNyushoshaSabisuKubun;
    @BatchParameter(key = SAKUJYOMERU, name = "削除含める")
    private boolean sakujyoMeru;

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public HanyoListKokuhorenJukyushaProcessParameter toProcessParameter() {
        return new HanyoListKokuhorenJukyushaProcessParameter(chohyoId,
                shutsuryokujunId,
                shutsuryokukomokuId,
                komokumeFuka,
                renbanFuka,
                hitsukeHenshu,
                hokenshaKodo,
                hitsukeChushutsuKubun,
                shoriTaishoNengetsuFrom,
                shoriTaishoNengetsuTo,
                idoNengetsuFrom,
                idoNengetsuTo,
                kakuidozukinoSaishinNomi,
                idoKubun,
                minashiYokaigoKubun,
                jigyoshaBanggo,
                kohiFutanJyogengakuGengaku,
                riyoshaFutanKubun,
                tokuteiNyushoshaSabisuKubun,
                sakujyoMeru);
    }
}
