/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shikakufuseigo;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ConfigKeysNenreiTotatsuKijunJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.fuseigoriyu.FuseigoRiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.tatokureiidojiyu.TatokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.tatokureiidojiyu.TatokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 資格不整合チェッククラス
 *
 * @reamsid_L DBB-0630-030 chengsanyuan
 */
public class ShikakuJukiValidator {

    private static final int AGE_65 = 65;
    private static final RString 対象項目_資格取得日 = new RString("資格取得日");
    private static final RString 対象項目_資格喪失日 = new RString("資格喪失日");
    private static final RString 対象項目_資格変更日 = new RString("資格変更日");
    private static final RString 対象項目_他市町村住所地特例適用 = new RString("他市町村住所地特例適用.適用日");
    private static final RString 対象項目_他市町村住所地特例解除 = new RString("他市町村住所地特例解除.解除日");
    private static final RString 対象項目_適用除外適用 = new RString("適用除外適用.適用日");
    private static final RString 対象項目_適用除外解除 = new RString("適用除外解除.解除日");

    /**
     * コンストラクタです。
     */
    ShikakuJukiValidator() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShikakuJukiValidator}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShikakuJukiValidator}のインスタンス
     */
    public static ShikakuJukiValidator createInstance() {
        return InstanceProvider.create(ShikakuJukiValidator.class);
    }

    /**
     * パラメータの個人と、被保険者台帳の情報を比較して、不整合チェック結果オブジェクトのインスタンスを返却します。
     *
     * @param 個人情報 IKojin
     * @param 資格の情報 HihokenshaDaicho
     * @return FuseigoRiyu
     * @exception IllegalStateException
     */
    public FuseigoRiyu checkFor資格不整合(IKojin 個人情報, HihokenshaDaicho 資格の情報) {
        if (資格の情報 != null && 資格の情報.get識別コード().compareTo(個人情報.get識別コード()) != 0) {
            throw new IllegalStateException("同一人を比較しなければ意味がないため。");
        }
        FuseigoRiyu 不整合理由 = null;
        if (資格の情報 == null) {
            RString 基準年齢 = BusinessConfig.get(ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢,
                    SubGyomuCode.DBU介護統計報告);
            RString 年齢 = 個人情報.get年齢算出().get年齢();
            if (Integer.parseInt(基準年齢.toString()) <= Integer.parseInt(年齢.toString())) {
                不整合理由 = FuseigoRiyu.資格管理情報未登録者;
            }
            return 不整合理由;
        }
        if (JukiIdoJiyu.転入.get異動事由コード().equals(個人情報.get登録事由().get異動事由コード())
                && ShikakuShutokuJiyu.転入.getコード().equals(資格の情報.get資格取得事由コード())
                && 資格の情報.get資格取得年月日().compareTo(個人情報.get登録異動年月日()) != 0) {
            不整合理由 = FuseigoRiyu.資格取得日_転入者;
        }
        if (ShikakuShutokuJiyu.年齢到達.getコード().equals(資格の情報.get資格取得事由コード())
                && 資格の情報.get資格取得年月日().compareTo(個人情報.get年齢算出().get年齢到達日(AGE_65)) != 0) {
            不整合理由 = FuseigoRiyu.資格取得日_年齢到達者;
        }
        if (JukiIdoJiyu.職権消除.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())) {
            if (isNullOrEmpty(資格の情報.get資格喪失年月日())) {
                不整合理由 = FuseigoRiyu.資格取得者_消除者;
            } else if (資格の情報.get資格喪失年月日().compareTo(個人情報.get消除異動年月日()) != 0) {
                不整合理由 = FuseigoRiyu.資格喪失日_住基不一致;
            }

        }
        if (JukiIdoJiyu.転出.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())) {
            不整合理由 = is転出の判定(資格の情報.get適用年月日(), 資格の情報.get解除年月日(),
                    資格の情報.get資格喪失年月日(), 資格の情報.get資格喪失事由コード(),
                    個人情報.get転出確定().get異動年月日(), 個人情報.get転出予定().get異動年月日(),
                    不整合理由);
        }
        if (JukiIdoJiyu.死亡.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())
                && isNullOrEmpty(資格の情報.get資格喪失年月日())) {
            不整合理由 = FuseigoRiyu.資格取得者_死亡者;
        }
        if (ShikakuHenkoJiyu._１号到達.getコード().equals(資格の情報.get資格変更事由コード())
                && (!個人情報.get生年月日().toFlexibleDate().isValid()
                || 資格の情報.get資格変更年月日().compareTo(個人情報.get年齢算出().get年齢到達日(AGE_65)) != 0)) {
            不整合理由 = FuseigoRiyu.資格取得者_死亡者;
        }

        return 不整合理由;
    }

    /**
     * パラメータの個人と、適用除外者の情報とを比較して、不整合チェック結果オブジェクトのインスタンスを返却します。
     *
     * @param 個人情報 IKojin
     * @param 除外の情報 TekiyoJogaisha
     * @return FuseigoRiyu
     */
    public FuseigoRiyu checkFor除外不整合(IKojin 個人情報, TekiyoJogaisha 除外の情報) {
        FuseigoRiyu 不整合理由 = null;
        if (JukiIdoJiyu.転入.get異動事由コード().equals(個人情報.get登録事由().get異動事由コード())
                && JogaiTekiyoJiyu.除外者適用.getコード().equals(除外の情報.get適用除外適用事由コード())
                && 除外の情報.get適用年月日().compareTo(個人情報.get登録異動年月日()) != 0) {
            不整合理由 = FuseigoRiyu.除外適用日_転入者;
        }
        if (JukiIdoJiyu.職権消除.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())
                || JukiIdoJiyu.死亡.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())
                && (is除外住基不一致の判定(除外の情報.get解除年月日(), 個人情報.get消除事由().get異動事由コード(),
                        除外の情報.get適用除外解除事由コード(), 個人情報.get消除異動年月日()))) {
            不整合理由 = FuseigoRiyu.除外解除日_住基不一致;
        }
        if (JukiIdoJiyu.転出.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())
                && (is除外解除日転出確定者の判定(除外の情報.get適用除外解除事由コード(),
                        除外の情報.get解除年月日(), 個人情報.get転出確定().get異動年月日().plusDay(1)))) {
            不整合理由 = FuseigoRiyu.除外解除日_転出確定者;
        }
        if (JukiIdoJiyu.転入通知受理.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())
                && (is除外解除日転出確定者の判定(除外の情報.get適用除外解除事由コード(),
                        除外の情報.get解除年月日(), 個人情報.get転出予定().get異動年月日()))) {
            不整合理由 = FuseigoRiyu.除外解除日_転出予定者;
        }

        return 不整合理由;
    }

    /**
     * パラメータの個人と、他市町村住所地特例の情報とを比較して、不整合チェック結果オブジェクトのインスタンスを返却します。
     *
     * @param 個人情報 IKojin
     * @param 他特の情報 TashichosonJushochiTokurei
     * @return FuseigoRiyu
     */
    public FuseigoRiyu checkFor他特不整合(IKojin 個人情報, TashichosonJushochiTokurei 他特の情報) {
        FuseigoRiyu 不整合理由 = null;
        if (JukiIdoJiyu.転入.get異動事由コード().equals(個人情報.get登録事由().get異動事由コード())
                && TatokureiTekiyoJiyu.他特例適用.getコード().equals(他特の情報.get他市町村住所地特例適用事由コード())
                && 他特の情報.get適用年月日().compareTo(個人情報.get登録異動年月日()) != 0) {
            不整合理由 = FuseigoRiyu.他住所地特例適用日_転入者;
        }
        if (JukiIdoJiyu.職権消除.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())
                || JukiIdoJiyu.死亡.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())
                && (is他特住基不一致の判定(他特の情報.get解除年月日(), 個人情報.get消除事由().get異動事由コード(),
                        他特の情報.get他市町村住所地特例解除事由コード(), 個人情報.get消除異動年月日()))) {
            不整合理由 = FuseigoRiyu.他住所地特例解除日_住基不一致;
        }
        if (JukiIdoJiyu.転出.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())
                && is除外解除日転出確定者の判定(他特の情報.get他市町村住所地特例解除事由コード(),
                        他特の情報.get解除年月日(), 個人情報.get転出確定().get異動年月日().plusDay(1))) {
            不整合理由 = FuseigoRiyu.他住所地特例解除日_転出確定者;
        }
        if (JukiIdoJiyu.転入通知受理.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())
                && is除外解除日転出確定者の判定(他特の情報.get他市町村住所地特例解除事由コード(),
                        他特の情報.get解除年月日(), 個人情報.get転出予定().get異動年月日())) {
            不整合理由 = FuseigoRiyu.他住所地特例解除日_転出予定者;
        }
        return 不整合理由;
    }

    /**
     * 不整合理由からバリデーションメッセージを作成し、返却します。
     *
     * @param 不整合理由 FuseigoRiyu
     * @param 個人情報 IKojin
     * @return Map<DbzErrorMessages, RString>
     */
    public Map<DbzErrorMessages, RString> createValidationMessages(FuseigoRiyu 不整合理由, IKojin 個人情報) {
        Map<DbzErrorMessages, RString> retMap = new HashMap<>();
        switch (不整合理由) {
            case 資格管理情報未登録者:
                break;
            case 資格取得日_転入者:
                retMap.put(DbzErrorMessages.資格不整合_転入, 対象項目_資格取得日);
                break;
            case 資格取得日_年齢到達者:
                retMap.put(DbzErrorMessages.資格不整合_年齢到達, 対象項目_資格取得日);
                break;
            case 資格取得者_消除者:
                retMap.put(DbzErrorMessages.資格不整合_職権削除, 対象項目_資格喪失日);
                break;
            case 資格取得者_転出者:
                setMsg(retMap, 個人情報);
                break;
            case 資格取得者_死亡者:
                retMap.put(DbzErrorMessages.資格不整合_死亡, 対象項目_資格喪失日);
                break;
            case 資格喪失日_住基不一致:
                retMap.put(DbzErrorMessages.資格不整合_1号年齢到達, 対象項目_資格喪失日);
                break;
            case 資格喪失日_転出予定者:
                retMap.put(DbzErrorMessages.資格不整合_転出_転出予定日, 対象項目_資格喪失日);
                break;
            case 資格喪失日_転出確定者:
                retMap.put(DbzErrorMessages.資格不整合_転出_転出確定日, 対象項目_資格喪失日);
                break;
            case 資格変更者_１号被保険者到達:
                retMap.put(DbzErrorMessages.指定数誤り, 対象項目_資格変更日);
                break;
            case 他住所地特例適用日_転入者:
                retMap.put(DbzErrorMessages.他住所地特例適用日_転入者, 対象項目_他市町村住所地特例適用);
                break;
            case 他住所地特例解除日_住基不一致:
                retMap.put(DbzErrorMessages.他住所地特例解除日_住基不一致, 対象項目_他市町村住所地特例解除);
                break;
            case 他住所地特例解除日_転出予定者:
                retMap.put(DbzErrorMessages.他住所地特例解除日_転出予定者, 対象項目_他市町村住所地特例解除);
                break;
            case 他住所地特例解除日_転出確定者:
                retMap.put(DbzErrorMessages.他住所地特例解除日_転出確定者, 対象項目_他市町村住所地特例解除);
                break;
            case 除外適用日_転入者:
                retMap.put(DbzErrorMessages.除外適用日_転入者, 対象項目_適用除外適用);
                break;
            case 除外解除日_住基不一致:
                retMap.put(DbzErrorMessages.除外解除日_住基不一致, 対象項目_適用除外解除);
                break;
            case 除外解除日_転出予定者:
                retMap.put(DbzErrorMessages.除外解除日_転出予定者, 対象項目_適用除外解除);
                break;
            case 除外解除日_転出確定者:
                retMap.put(DbzErrorMessages.除外解除日_転出確定者, 対象項目_適用除外解除);
                break;
            default:
                break;
        }
        return retMap;
    }

    /**
     * パラメータの個人と、被保険者台帳の情報を比較して、バリデーションメッセージを返却します。
     *
     * @param 個人情報 IKojin
     * @param 資格の情報 HihokenshaDaicho
     * @return Map<DbzErrorMessages, RString>
     */
    public Map<DbzErrorMessages, RString> validate(IKojin 個人情報, HihokenshaDaicho 資格の情報) {
        return createValidationMessages(checkFor資格不整合(個人情報, 資格の情報), 個人情報);
    }

    /**
     * パラメータの個人と、適用除外者の情報を比較して、バリデーションメッセージを返却します。
     *
     * @param 個人情報 IKojin
     * @param 除外の情報 TekiyoJogaisha
     * @return Map<DbzErrorMessages, RString>
     */
    public Map<DbzErrorMessages, RString> validate適用除外者(IKojin 個人情報, TekiyoJogaisha 除外の情報) {
        return createValidationMessages(checkFor除外不整合(個人情報, 除外の情報), 個人情報);
    }

    /**
     * パラメータの個人と、他市町村住所地特例の情報を比較して、バリデーションメッセージを返却します。
     *
     * @param 個人情報 IKojin
     * @param 他特の情報 TashichosonJushochiTokurei
     * @return Map<DbzErrorMessages, RString>
     */
    public Map<DbzErrorMessages, RString> validate他特例(IKojin 個人情報, TashichosonJushochiTokurei 他特の情報) {
        return createValidationMessages(checkFor他特不整合(個人情報, 他特の情報), 個人情報);
    }

    private void setMsg(Map<DbzErrorMessages, RString> retMap, IKojin 個人情報) {
        if (isNullOrEmpty(個人情報.get転出確定().get異動年月日())) {
            retMap.put(DbzErrorMessages.資格不整合_転出_転出確定日, 対象項目_資格喪失日);
        } else {
            retMap.put(DbzErrorMessages.資格不整合_転出_転出予定日, 対象項目_資格喪失日);
        }
    }

    private boolean is除外解除日転出確定者の判定(RString 異動事由コード, FlexibleDate 解除年月日, FlexibleDate 異動年月日) {
        if (!JogaiKaijoJiyu.除外者転出.getコード().equals(異動事由コード)) {
            return true;
        }
        return 解除年月日.compareTo(異動年月日) != 0 && JogaiKaijoJiyu.除外者転出.getコード().equals(異動事由コード);
    }

    private boolean is除外住基不一致の判定(FlexibleDate 解除年月日, RString 消除事由, RString 解除事由, FlexibleDate 消除異動年月日) {
        boolean flag1 = isNullOrEmpty(解除年月日);
        boolean flag2 = JukiIdoJiyu.死亡.get異動事由コード().equals(消除事由)
                && !JogaiKaijoJiyu.除外者死亡.getコード().equals(解除事由);
        boolean flag3 = JukiIdoJiyu.職権消除.get異動事由コード().equals(消除事由)
                && !JogaiKaijoJiyu.職権解除.getコード().equals(消除事由);
        boolean flag4 = JukiIdoJiyu.死亡.get異動事由コード().equals(消除事由)
                && JogaiKaijoJiyu.除外者死亡.getコード().equals(解除事由)
                && 解除年月日.compareTo(消除異動年月日.plusDay(1)) != 0;
        boolean flag5 = JukiIdoJiyu.職権消除.get異動事由コード().equals(消除事由)
                && JogaiKaijoJiyu.職権解除.getコード().equals(消除事由)
                && 解除年月日.compareTo(消除異動年月日.plusDay(1)) != 0;
        return flag1 || flag2 || flag3 || flag4 || flag5;
    }

    private boolean is他特住基不一致の判定(FlexibleDate 解除年月日, RString 消除事由, RString 解除事由, FlexibleDate 消除異動年月日) {
        boolean flag1 = isNullOrEmpty(解除年月日);
        boolean flag2 = JukiIdoJiyu.死亡.get異動事由コード().equals(消除事由)
                && !TatokureiKaijoJiyu.他特例死亡.getコード().equals(解除事由);
        boolean flag3 = JukiIdoJiyu.職権消除.get異動事由コード().equals(消除事由)
                && !TatokureiKaijoJiyu.職権解除.getコード().equals(消除事由);
        boolean flag4 = JukiIdoJiyu.死亡.get異動事由コード().equals(消除事由)
                && TatokureiKaijoJiyu.他特例死亡.getコード().equals(解除事由)
                && 解除年月日.compareTo(消除異動年月日.plusDay(1)) != 0;
        boolean flag5 = JukiIdoJiyu.職権消除.get異動事由コード().equals(消除事由)
                && TatokureiKaijoJiyu.職権解除.getコード().equals(消除事由)
                && 解除年月日.compareTo(消除異動年月日.plusDay(1)) != 0;
        return flag1 || flag2 || flag3 || flag4 || flag5;
    }

    private boolean isNullOrEmpty(FlexibleDate checkDate) {
        return checkDate == null || checkDate.isEmpty();
    }

    private FuseigoRiyu is転出の判定(FlexibleDate 適用年月日, FlexibleDate 解除年月日,
            FlexibleDate 資格喪失年月日, RString 資格喪失事由コード,
            FlexibleDate 転出確定, FlexibleDate 転出予定,
            FuseigoRiyu 不整合理由) {
        if (isNullOrEmpty(適用年月日) && !isNullOrEmpty(解除年月日) && isNullOrEmpty(資格喪失年月日)) {
            不整合理由 = FuseigoRiyu.資格取得者_転出者;
        }
        if (ShikakuSoshitsuJiyu.転出.getコード().equals(資格喪失事由コード)) {
            if (!isNullOrEmpty(資格喪失年月日)
                    && 資格喪失年月日.compareTo(転出確定) != 0) {
                不整合理由 = FuseigoRiyu.資格喪失日_転出確定者;
            }
            if (資格喪失年月日.compareTo(転出予定) != 0) {
                不整合理由 = FuseigoRiyu.資格喪失日_転出予定者;
            }
        }
        return 不整合理由;
    }
}
