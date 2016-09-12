/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shikakufuseigo;

import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokureiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaishaBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysNenreiTotatsuKijunJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.fuseigoriyu.FuseigoRiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.tatokureiidojiyu.TatokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.tatokureiidojiyu.TatokureiTekiyoJiyu;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 資格不整合修正ロジッククラス
 *
 * @reamsid_L DBB-0630-060 chengsanyuan
 */
public class ShikakuFuseigoCorrector {

    private static final int FLAG_1 = 1;
    private static final int FLAG_2 = 2;
    private static final int FLAG_3 = 3;

    private static final int NUMBER_4 = 4;
    private final int 第１号被保険者到達基準年齢;

    /**
     * コンストラクタです。
     */
    ShikakuFuseigoCorrector() {
        第１号被保険者到達基準年齢 = Integer.valueOf(DbBusinessConfig.get(
                ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString());
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShikakuFuseigoCorrector}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShikakuFuseigoCorrector}のインスタンス
     */
    public static ShikakuFuseigoCorrector createInstance() {
        return InstanceProvider.create(ShikakuFuseigoCorrector.class);
    }

    /**
     * 入力の不整合理由と個人の情報、(不整合のある)資格の情報を元に、整合のとれた新しい資格の情報を作成し、返却します
     *
     * @param 資格の情報修正前 HihokenshaDaicho
     * @param 個人情報 IKojin
     * @param 不整合理由 FuseigoRiyu
     * @return HihokenshaDaicho
     */
    public HihokenshaDaicho correct資格不整合(HihokenshaDaicho 資格の情報修正前,
            IKojin 個人情報, FuseigoRiyu 不整合理由) {
        if (不整合理由 == FuseigoRiyu.資格取得日_転入者) {
            HihokenshaDaicho 資格の情報修正後 = getHihokenshaDaicho(資格の情報修正前, 個人情報.get登録異動年月日());
            資格の情報修正後 = set資格の情報(資格の情報修正前, 資格の情報修正後, FLAG_1);
            HihokenshaDaichoBuilder 資格の情報修正後Builder = 資格の情報修正後.createBuilderForEdit();
            資格の情報修正後Builder.set資格取得年月日(個人情報.get登録異動年月日());
            資格の情報修正後Builder.set第1号資格取得年月日(個人情報.get登録異動年月日());
            資格の情報修正後Builder.set資格取得届出年月日(個人情報.get登録異動年月日());
            資格の情報修正後Builder.set資格取得事由コード(ShikakuShutokuJiyu.転入.getコード());
            資格の情報修正後Builder.set異動事由コード(ShikakuShutokuJiyu.転入.getコード());
            return 資格の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.資格取得日_年齢到達者) {
            HihokenshaDaicho 資格の情報修正後 = getHihokenshaDaicho(資格の情報修正前, 個人情報.get年齢算出().get年齢到達日(
                    第１号被保険者到達基準年齢));
            資格の情報修正後 = set資格の情報(資格の情報修正前, 資格の情報修正後, FLAG_1);
            HihokenshaDaichoBuilder 資格の情報修正後Builder = 資格の情報修正後.createBuilderForEdit();
            資格の情報修正後Builder.set資格取得年月日(個人情報.get年齢算出().get年齢到達日(第１号被保険者到達基準年齢));
            資格の情報修正後Builder.set第1号資格取得年月日(個人情報.get年齢算出().get年齢到達日(第１号被保険者到達基準年齢));
            資格の情報修正後Builder.set資格取得届出年月日(個人情報.get年齢算出().get年齢到達日(第１号被保険者到達基準年齢));
            資格の情報修正後Builder.set資格取得事由コード(ShikakuShutokuJiyu.年齢到達.getコード());
            資格の情報修正後Builder.set異動事由コード(ShikakuShutokuJiyu.年齢到達.getコード());
            return 資格の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.資格取得者_消除者 || 不整合理由 == FuseigoRiyu.資格喪失日_住基不一致) {
            HihokenshaDaicho 資格の情報修正後 = getHihokenshaDaicho(資格の情報修正前, 個人情報.get消除異動年月日());
            資格の情報修正後 = set資格の情報(資格の情報修正前, 資格の情報修正後, FLAG_2);
            HihokenshaDaichoBuilder 資格の情報修正後Builder = 資格の情報修正後.createBuilderForEdit();
            資格の情報修正後Builder.set資格喪失年月日(個人情報.get消除異動年月日());
            資格の情報修正後Builder.set資格喪失届出年月日(個人情報.get消除異動年月日());
            資格の情報修正後Builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.職権喪失.getコード());
            資格の情報修正後Builder.set異動事由コード(ShikakuSoshitsuJiyu.職権喪失.getコード());
            return 資格の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.資格取得者_転出者) {
            FlexibleDate 資格喪失年月日 = null;
            if (個人情報.get転出確定().get異動年月日() != null && !個人情報.get転出確定().get異動年月日().isEmpty()) {
                資格喪失年月日 = 個人情報.get転出確定().get異動年月日();
            } else {
                資格喪失年月日 = 個人情報.get転出予定().get異動年月日();
            }
            HihokenshaDaicho 資格の情報修正後 = getHihokenshaDaicho(資格の情報修正前, 資格喪失年月日);
            資格の情報修正後 = set資格の情報(資格の情報修正前, 資格の情報修正後, FLAG_2);
            HihokenshaDaichoBuilder 資格の情報修正後Builder = 資格の情報修正後.createBuilderForEdit();
            資格の情報修正後Builder.set資格喪失年月日(資格喪失年月日);
            資格の情報修正後Builder.set資格喪失届出年月日(資格喪失年月日);
            資格の情報修正後Builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.転出.getコード());
            資格の情報修正後Builder.set異動事由コード(ShikakuSoshitsuJiyu.転出.getコード());
            return 資格の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.資格喪失日_転出確定者) {
            HihokenshaDaicho 資格の情報修正後 = getHihokenshaDaicho(資格の情報修正前, 個人情報.get転出確定().get異動年月日());
            資格の情報修正後 = set資格の情報(資格の情報修正前, 資格の情報修正後, FLAG_2);
            HihokenshaDaichoBuilder 資格の情報修正後Builder = 資格の情報修正後.createBuilderForEdit();
            資格の情報修正後Builder.set資格喪失年月日(個人情報.get転出確定().get異動年月日());
            資格の情報修正後Builder.set資格喪失届出年月日(個人情報.get転出確定().get異動年月日());
            資格の情報修正後Builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.転出.getコード());
            資格の情報修正後Builder.set異動事由コード(ShikakuSoshitsuJiyu.転出.getコード());
            return 資格の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.資格喪失日_転出予定者) {
            HihokenshaDaicho 資格の情報修正後 = getHihokenshaDaicho(資格の情報修正前, 個人情報.get転出予定().get異動年月日());
            資格の情報修正後 = set資格の情報(資格の情報修正前, 資格の情報修正後, FLAG_2);
            HihokenshaDaichoBuilder 資格の情報修正後Builder = 資格の情報修正後.createBuilderForEdit();
            資格の情報修正後Builder.set資格喪失年月日(個人情報.get転出予定().get異動年月日());
            資格の情報修正後Builder.set資格喪失届出年月日(個人情報.get転出予定().get異動年月日());
            資格の情報修正後Builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.転出.getコード());
            資格の情報修正後Builder.set異動事由コード(ShikakuSoshitsuJiyu.転出.getコード());
            return 資格の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.資格取得者_死亡者) {
            HihokenshaDaicho 資格の情報修正後 = getHihokenshaDaicho(資格の情報修正前, 個人情報.get消除異動年月日());
            資格の情報修正後 = set資格の情報(資格の情報修正前, 資格の情報修正後, FLAG_2);
            HihokenshaDaichoBuilder 資格の情報修正後Builder = 資格の情報修正後.createBuilderForEdit();
            資格の情報修正後Builder.set資格喪失年月日(個人情報.get消除異動年月日());
            資格の情報修正後Builder.set資格喪失届出年月日(個人情報.get消除異動年月日());
            資格の情報修正後Builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.死亡.getコード());
            資格の情報修正後Builder.set異動事由コード(ShikakuSoshitsuJiyu.死亡.getコード());
            return 資格の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.資格変更者_１号被保険者到達) {
            HihokenshaDaicho 資格の情報修正後 = getHihokenshaDaicho(資格の情報修正前, 個人情報.get消除異動年月日());
            資格の情報修正後 = set資格の情報(資格の情報修正前, 資格の情報修正後, FLAG_3);
            HihokenshaDaichoBuilder 資格の情報修正後Builder = 資格の情報修正後.createBuilderForEdit();
            資格の情報修正後Builder.set資格変更年月日(個人情報.get消除異動年月日());
            資格の情報修正後Builder.set資格変更届出年月日(個人情報.get消除異動年月日());
            資格の情報修正後Builder.set資格変更事由コード(ShikakuHenkoJiyu._１号到達.getコード());
            資格の情報修正後Builder.set異動事由コード(ShikakuHenkoJiyu._１号到達.getコード());
            return 資格の情報修正後Builder.build();
        }
        return 資格の情報修正前;
    }

    /**
     * 入力の不整合理由と個人の情報、(不整合のある)適用除外者の情報を元に、 整合のとれた新しい除外の情報を作成し、返却します。
     *
     * @param 除外の情報修正前 TekiyoJogaisha
     * @param 個人情報 IKojin
     * @param 不整合理由 FuseigoRiyu
     * @return TekiyoJogaisha
     */
    public TekiyoJogaisha correct除外不整合(TekiyoJogaisha 除外の情報修正前,
            IKojin 個人情報, FuseigoRiyu 不整合理由) {
        if (不整合理由 == FuseigoRiyu.除外適用日_転入者) {
            TekiyoJogaisha 除外の情報修正後 = getTekiyoJogaisha(除外の情報修正前, 個人情報.get登録異動年月日());
            除外の情報修正後 = set除外の情報(除外の情報修正前, 除外の情報修正後, FLAG_1);
            TekiyoJogaishaBuilder 除外の情報修正後Builder = 除外の情報修正後.createBuilderForEdit();
            除外の情報修正後Builder.set適用除外適用事由コード(JogaiTekiyoJiyu.除外者適用.getコード());
            除外の情報修正後Builder.set適用年月日(個人情報.get登録異動年月日());
            除外の情報修正後Builder.set適用届出年月日(個人情報.get登録異動年月日());
            return 除外の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.除外解除日_住基不一致) {
            TekiyoJogaisha 除外の情報修正後 = getTekiyoJogaisha(除外の情報修正前,
                    個人情報.get消除異動年月日().plusDay(FLAG_1));
            除外の情報修正後 = set除外の情報(除外の情報修正前, 除外の情報修正後, FLAG_2);
            TekiyoJogaishaBuilder 除外の情報修正後Builder = 除外の情報修正後.createBuilderForEdit();
            if (JukiIdoJiyu.死亡.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())) {
                除外の情報修正後Builder.set適用除外解除事由コード(JogaiKaijoJiyu.除外者死亡.getコード());
            }
            if (JukiIdoJiyu.職権消除.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())) {
                除外の情報修正後Builder.set適用除外解除事由コード(JogaiKaijoJiyu.職権解除.getコード());
            }
            除外の情報修正後Builder.set解除年月日(個人情報.get消除異動年月日().plusDay(FLAG_1));
            除外の情報修正後Builder.set解除届出年月日(個人情報.get消除異動年月日().plusDay(FLAG_1));
            return 除外の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.除外解除日_転出確定者) {
            TekiyoJogaisha 除外の情報修正後 = getTekiyoJogaisha(除外の情報修正前,
                    個人情報.get転出確定().get異動年月日().plusDay(FLAG_1));
            除外の情報修正後 = set除外の情報(除外の情報修正前, 除外の情報修正後, FLAG_2);
            TekiyoJogaishaBuilder 除外の情報修正後Builder = 除外の情報修正後.createBuilderForEdit();
            除外の情報修正後Builder.set適用除外解除事由コード(JogaiKaijoJiyu.除外者転出.getコード());
            除外の情報修正後Builder.set解除年月日(個人情報.get転出確定().get異動年月日().plusDay(FLAG_1));
            除外の情報修正後Builder.set解除届出年月日(個人情報.get転出確定().get異動年月日().plusDay(FLAG_1));
            return 除外の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.除外解除日_転出予定者) {
            TekiyoJogaisha 除外の情報修正後 = getTekiyoJogaisha(除外の情報修正前, 個人情報.get転出予定().get異動年月日());
            除外の情報修正後 = set除外の情報(除外の情報修正前, 除外の情報修正後, FLAG_2);
            TekiyoJogaishaBuilder 除外の情報修正後Builder = 除外の情報修正後.createBuilderForEdit();
            除外の情報修正後Builder.set適用除外解除事由コード(JogaiKaijoJiyu.除外者転出.getコード());
            除外の情報修正後Builder.set解除年月日(個人情報.get転出予定().get異動年月日());
            除外の情報修正後Builder.set解除届出年月日(個人情報.get転出予定().get異動年月日());
            return 除外の情報修正後Builder.build();
        }
        return 除外の情報修正前;
    }

    /**
     * 入力の不整合理由と個人の情報、(不整合のある)他市町村住所地特例の情報を元に、整合のとれた新しい他特の情報を作成し、返却します。
     *
     * @param 他特の情報修正前 TashichosonJushochiTokurei
     * @param 個人情報 IKojin
     * @param 不整合理由 FuseigoRiyu
     * @return TashichosonJushochiTokurei
     */
    public TashichosonJushochiTokurei correct他特例不整合(TashichosonJushochiTokurei 他特の情報修正前,
            IKojin 個人情報, FuseigoRiyu 不整合理由) {

        if (不整合理由 == FuseigoRiyu.他住所地特例適用日_転入者) {
            TashichosonJushochiTokurei 他特の情報修正後 = getTashichosonJushochiTokurei(他特の情報修正前,
                    個人情報.get登録異動年月日());
            他特の情報修正後 = set他特の情報(他特の情報修正前, 他特の情報修正後, FLAG_1);
            TashichosonJushochiTokureiBuilder 他特の情報修正後Builder = 他特の情報修正後.createBuilderForEdit();
            他特の情報修正後Builder.set他市町村住所地特例適用事由コード(TatokureiTekiyoJiyu.他特例適用.getコード());
            他特の情報修正後Builder.set適用年月日(個人情報.get登録異動年月日());
            他特の情報修正後Builder.set適用届出年月日(個人情報.get登録異動年月日());
            return 他特の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.他住所地特例解除日_住基不一致) {
            TashichosonJushochiTokurei 他特の情報修正後 = getTashichosonJushochiTokurei(他特の情報修正前,
                    個人情報.get消除異動年月日().plusDay(FLAG_1));
            他特の情報修正後 = set他特の情報(他特の情報修正前, 他特の情報修正後, FLAG_2);
            TashichosonJushochiTokureiBuilder 他特の情報修正後Builder = 他特の情報修正後.createBuilderForEdit();
            if (JukiIdoJiyu.死亡.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())) {
                他特の情報修正後Builder.set他市町村住所地特例解除事由コード(TatokureiKaijoJiyu.他特例死亡.getコード());
            }
            if (JukiIdoJiyu.職権消除.get異動事由コード().equals(個人情報.get消除事由().get異動事由コード())) {
                他特の情報修正後Builder.set他市町村住所地特例解除事由コード(TatokureiKaijoJiyu.職権解除.getコード());
            }
            他特の情報修正後Builder.set解除年月日(個人情報.get消除異動年月日().plusDay(FLAG_1));
            他特の情報修正後Builder.set解除届出年月日(個人情報.get消除異動年月日().plusDay(FLAG_1));
            return 他特の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.他住所地特例解除日_転出確定者) {
            TashichosonJushochiTokurei 他特の情報修正後 = getTashichosonJushochiTokurei(他特の情報修正前,
                    個人情報.get転出確定().get異動年月日().plusDay(FLAG_1));
            他特の情報修正後 = set他特の情報(他特の情報修正前, 他特の情報修正後, FLAG_2);
            TashichosonJushochiTokureiBuilder 他特の情報修正後Builder = 他特の情報修正後.createBuilderForEdit();
            他特の情報修正後Builder.set他市町村住所地特例解除事由コード(TatokureiKaijoJiyu.他特例転出.getコード());
            他特の情報修正後Builder.set解除年月日(個人情報.get転出確定().get異動年月日().plusDay(FLAG_1));
            他特の情報修正後Builder.set解除届出年月日(個人情報.get転出確定().get異動年月日().plusDay(FLAG_1));
            return 他特の情報修正後Builder.build();
        }
        if (不整合理由 == FuseigoRiyu.他住所地特例解除日_転出予定者) {
            TashichosonJushochiTokurei 他特の情報修正後 = getTashichosonJushochiTokurei(他特の情報修正前,
                    個人情報.get転出予定().get異動年月日());
            他特の情報修正後 = set他特の情報(他特の情報修正前, 他特の情報修正後, FLAG_2);
            TashichosonJushochiTokureiBuilder 他特の情報修正後Builder = 他特の情報修正後.createBuilderForEdit();
            他特の情報修正後Builder.set他市町村住所地特例解除事由コード(TatokureiKaijoJiyu.他特例転出.getコード());
            他特の情報修正後Builder.set解除年月日(個人情報.get転出予定().get異動年月日());
            他特の情報修正後Builder.set解除届出年月日(個人情報.get転出予定().get異動年月日());
            return 他特の情報修正後Builder.build();
        }
        return 他特の情報修正前;
    }

    private HihokenshaDaicho set資格の情報(HihokenshaDaicho 資格の情報修正前, HihokenshaDaicho 資格の情報修正後, int flag) {
        HihokenshaDaichoBuilder 資格の情報修正後Builder = 資格の情報修正後.createBuilderForEdit();
        資格の情報修正後Builder.set市町村コード(資格の情報修正前.get市町村コード());
        資格の情報修正後Builder.set識別コード(資格の情報修正前.get識別コード());

        資格の情報修正後Builder.set被保険者区分コード(資格の情報修正前.get被保険者区分コード());
        if (flag == FLAG_1) {
            資格の情報修正後Builder.set資格喪失事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get資格喪失事由コード(), RString.EMPTY));
            資格の情報修正後Builder.set資格喪失年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格喪失年月日(), FlexibleDate.EMPTY));
            資格の情報修正後Builder.set資格喪失届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格喪失届出年月日(), FlexibleDate.EMPTY));
            資格の情報修正後Builder.set資格変更事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get資格変更事由コード(), RString.EMPTY));
            資格の情報修正後Builder.set資格変更年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格変更年月日(), FlexibleDate.EMPTY));
            資格の情報修正後Builder.set資格変更届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格変更届出年月日(), FlexibleDate.EMPTY));
        }
        if (flag == FLAG_2) {
            資格の情報修正後Builder.set資格取得事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get資格取得事由コード(), RString.EMPTY));
            資格の情報修正後Builder.set資格取得年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格取得年月日(), FlexibleDate.EMPTY));
            資格の情報修正後Builder.set資格取得届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格取得届出年月日(), FlexibleDate.EMPTY));
            資格の情報修正後Builder.set第1号資格取得年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get第1号資格取得年月日(), FlexibleDate.EMPTY));
            資格の情報修正後Builder.set資格変更事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get資格変更事由コード(), RString.EMPTY));
            資格の情報修正後Builder.set資格変更年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格変更年月日(), FlexibleDate.EMPTY));
            資格の情報修正後Builder.set資格変更届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格変更届出年月日(), FlexibleDate.EMPTY));
        }
        if (flag == FLAG_3) {
            資格の情報修正後Builder.set資格喪失事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get資格喪失事由コード(), RString.EMPTY));
            資格の情報修正後Builder.set資格喪失年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格喪失年月日(), FlexibleDate.EMPTY));
            資格の情報修正後Builder.set資格喪失届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格喪失届出年月日(), FlexibleDate.EMPTY));
            資格の情報修正後Builder.set資格取得事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get資格取得事由コード(), RString.EMPTY));
            資格の情報修正後Builder.set資格取得年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格取得年月日(), FlexibleDate.EMPTY));
            資格の情報修正後Builder.set資格取得届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格取得届出年月日(), FlexibleDate.EMPTY));
        }
        資格の情報修正後Builder.set住所地特例適用事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get住所地特例適用事由コード(), RString.EMPTY));
        資格の情報修正後Builder.set適用年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get適用年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set適用届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get適用届出年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set住所地特例解除事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get住所地特例解除事由コード(), RString.EMPTY));
        資格の情報修正後Builder.set解除年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get解除年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set解除届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get解除届出年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set住所地特例フラグ(ObjectUtil.defaultIfNull(資格の情報修正前.get住所地特例フラグ(), RString.EMPTY));
        資格の情報修正後Builder.set広域内住所地特例フラグ(ObjectUtil.defaultIfNull(資格の情報修正前.get広域内住所地特例フラグ(), RString.EMPTY));
        資格の情報修正後Builder.set広住特措置元市町村コード(ObjectUtil.defaultIfNull(資格の情報修正前.get広住特措置元市町村コード(), LasdecCode.EMPTY));
        資格の情報修正後Builder.set旧市町村コード(ObjectUtil.defaultIfNull(資格の情報修正前.get旧市町村コード(), LasdecCode.EMPTY));
        資格の情報修正後Builder.set論理削除フラグ(ObjectUtil.defaultIfNull(資格の情報修正前.is論理削除フラグ(), false));

        return 資格の情報修正後Builder.build();
    }

    private TekiyoJogaisha set除外の情報(TekiyoJogaisha 除外の情報修正前, TekiyoJogaisha 除外の情報修正後, int flag) {
        TekiyoJogaishaBuilder 除外の情報修正後Builder = 除外の情報修正後.createBuilderForEdit();
        除外の情報修正後Builder.set異動事由コード(除外の情報修正前.get異動事由コード());
        除外の情報修正後Builder.set市町村コード(除外の情報修正前.get市町村コード());
        if (flag == FLAG_1) {
            除外の情報修正後Builder.set適用除外解除事由コード(ObjectUtil.defaultIfNull(除外の情報修正前.get適用除外解除事由コード(), RString.EMPTY));
            除外の情報修正後Builder.set解除年月日(ObjectUtil.defaultIfNull(除外の情報修正前.get解除年月日(), FlexibleDate.EMPTY));
            除外の情報修正後Builder.set解除届出年月日(ObjectUtil.defaultIfNull(除外の情報修正前.get解除届出年月日(), FlexibleDate.EMPTY));
        }
        if (flag == FLAG_2) {
            除外の情報修正後Builder.set適用除外適用事由コード(除外の情報修正前.get適用除外適用事由コード());
            除外の情報修正後Builder.set適用年月日(除外の情報修正前.get適用年月日());
            除外の情報修正後Builder.set適用届出年月日(ObjectUtil.defaultIfNull(除外の情報修正前.get適用届出年月日(), FlexibleDate.EMPTY));
        }
        除外の情報修正後Builder.set適用受付年月日(ObjectUtil.defaultIfNull(除外の情報修正前.get適用受付年月日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set解除受付年月日(ObjectUtil.defaultIfNull(除外の情報修正前.get解除受付年月日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set入所通知発行日(ObjectUtil.defaultIfNull(除外の情報修正前.get入所通知発行日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set退所通知発行日(ObjectUtil.defaultIfNull(除外の情報修正前.get退所通知発行日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set変更通知発行日(ObjectUtil.defaultIfNull(除外の情報修正前.get変更通知発行日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set論理削除フラグ(ObjectUtil.defaultIfNull(除外の情報修正前.is論理削除フラグ(), false));
        return 除外の情報修正後Builder.build();
    }

    private TashichosonJushochiTokurei set他特の情報(TashichosonJushochiTokurei 他特の情報修正前,
            TashichosonJushochiTokurei 他特の情報修正後, int flag) {
        TashichosonJushochiTokureiBuilder 他特の情報修正後Builder = 他特の情報修正後.createBuilderForEdit();
        他特の情報修正後Builder.set異動事由コード(他特の情報修正前.get異動事由コード());
        他特の情報修正後Builder.set市町村コード(他特の情報修正前.get市町村コード());
        if (flag == FLAG_2) {
            他特の情報修正後Builder.set他市町村住所地特例適用事由コード(他特の情報修正前.get他市町村住所地特例適用事由コード());
            他特の情報修正後Builder.set適用年月日(他特の情報修正前.get適用年月日());
            他特の情報修正後Builder.set適用届出年月日(ObjectUtil.defaultIfNull(他特の情報修正前.get適用届出年月日(), FlexibleDate.EMPTY));
        }
        他特の情報修正後Builder.set適用受付年月日(ObjectUtil.defaultIfNull(他特の情報修正前.get適用受付年月日(), FlexibleDate.EMPTY));
        if (flag == FLAG_1) {
            他特の情報修正後Builder.set他市町村住所地特例解除事由コード(
                    ObjectUtil.defaultIfNull(他特の情報修正前.get他市町村住所地特例解除事由コード(), RString.EMPTY));
            他特の情報修正後Builder.set解除年月日(ObjectUtil.defaultIfNull(他特の情報修正前.get解除年月日(), FlexibleDate.EMPTY));
            他特の情報修正後Builder.set解除届出年月日(ObjectUtil.defaultIfNull(他特の情報修正前.get解除届出年月日(), FlexibleDate.EMPTY));
        }
        他特の情報修正後Builder.set解除受付年月日(ObjectUtil.defaultIfNull(
                他特の情報修正前.get解除受付年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set措置保険者番号(ObjectUtil.defaultIfNull(
                他特の情報修正前.get措置保険者番号(), ShoKisaiHokenshaNo.EMPTY));
        他特の情報修正後Builder.set措置被保険者番号(ObjectUtil.defaultIfNull(他特の情報修正前.get措置被保険者番号(), HihokenshaNo.EMPTY));
        他特の情報修正後Builder.set他特例連絡票発行年月日(ObjectUtil.defaultIfNull(
                他特の情報修正前.get他特例連絡票発行年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set施設退所通知発行年月日(ObjectUtil.defaultIfNull(
                他特の情報修正前.get施設退所通知発行年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set施設変更通知発行年月日(ObjectUtil.defaultIfNull(
                他特の情報修正前.get施設変更通知発行年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set論理削除フラグ(ObjectUtil.defaultIfNull(他特の情報修正前.is論理削除フラグ(), false));

        return 他特の情報修正後Builder.build();
    }

    private HihokenshaDaicho getHihokenshaDaicho(HihokenshaDaicho 資格の情報修正前, FlexibleDate 異動日) {
        if (異動日.compareTo(資格の情報修正前.get異動日()) == 0) {
            return new HihokenshaDaicho(資格の情報修正前.get被保険者番号(), 異動日, add枝番(資格の情報修正前.get枝番()));
        }
        return new HihokenshaDaicho(資格の情報修正前.get被保険者番号(), 異動日, 資格の情報修正前.get枝番());
    }

    private TekiyoJogaisha getTekiyoJogaisha(TekiyoJogaisha 除外の情報修正前, FlexibleDate 異動日) {
        if (異動日.compareTo(除外の情報修正前.get異動日()) == 0) {
            return new TekiyoJogaisha(除外の情報修正前.get識別コード(), 異動日, add枝番(除外の情報修正前.get枝番()));
        }
        return new TekiyoJogaisha(除外の情報修正前.get識別コード(), 異動日, 除外の情報修正前.get枝番());
    }

    private TashichosonJushochiTokurei getTashichosonJushochiTokurei(
            TashichosonJushochiTokurei 他特の情報修正前, FlexibleDate 異動日) {
        if (異動日.compareTo(他特の情報修正前.get異動日()) == 0) {
            return new TashichosonJushochiTokurei(他特の情報修正前.get識別コード(), 異動日, add枝番(他特の情報修正前.get枝番()));
        }
        return new TashichosonJushochiTokurei(他特の情報修正前.get識別コード(), 異動日, 他特の情報修正前.get枝番());
    }

    private RString add枝番(RString 枝番) {
        return new RString(Integer.parseInt(枝番.toString()) + 1).padZeroToLeft(NUMBER_4);
    }
}
