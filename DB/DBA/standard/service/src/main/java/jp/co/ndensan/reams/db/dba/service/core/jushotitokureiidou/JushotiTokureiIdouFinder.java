/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jushotitokureiidou;

import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.HihokenshaDaichoDac;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介被保険者台帳管理（住所地特例異動）のビジネス処理です。
 *
 * @reamsid_L DBA-1380-030 lijia
 *
 */
public class JushotiTokureiIdouFinder {

    private final HihokenshaDaichoDac hihokenshaDaichoDac;
    private static final RString DBAMN25001_届出により適用 = new RString("DBAMN25001");
    private static final RString DBAMN25002_届出により解除 = new RString("DBAMN25002");
    private static final RString 適用 = new RString("適用");
    private static final RString 解除 = new RString("解除");
    private final HihokenshaShikakuShutokuManager hihokenshaShikakuShutoku = HihokenshaShikakuShutokuManager.createInstance();

    /**
     * コンストラクタです。
     */
    public JushotiTokureiIdouFinder() {
        this.hihokenshaDaichoDac = InstanceProvider.create(HihokenshaDaichoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NyutaishoshaKanriFinder}のインスタンスを返します。
     *
     * @return NyutaishoshaKanriFinder
     */
    public static JushotiTokureiIdouFinder createInstance() {
        return InstanceProvider.create(JushotiTokureiIdouFinder.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    JushotiTokureiIdouFinder(HihokenshaDaichoDac hihokenshaDaichoDac) {
        this.hihokenshaDaichoDac = hihokenshaDaichoDac;
    }

    /**
     * 介住所地特例異動チェック処理です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 適用日 FlexibleDate
     * @param 解除日 FlexibleDate
     */
    public void shikakuJutokuCheck(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 適用日, FlexibleDate 解除日) {
        HihokenshaShutokuJyoho hihokenshaShutokuJyoho = hihokenshaShikakuShutoku.getSaishinDeta(識別コード, 被保険者番号);
        if (hihokenshaShutokuJyoho == null) {
            return;
        }
        FlexibleDate 異動日 = hihokenshaShutokuJyoho.get異動日();
        FlexibleDate 適用年月日 = hihokenshaShutokuJyoho.get適用年月日();
        FlexibleDate 解除年月日 = hihokenshaShutokuJyoho.get解除年月日();
        if (DBAMN25001_届出により適用.equals(UrControlDataFactory.createInstance().getMenuID())) {
            適用解除日の存在性チェック(異動日, 適用日, 適用);
            適用期間が重複チェック(解除年月日, 適用日);
        }
        if (DBAMN25002_届出により解除.equals(UrControlDataFactory.createInstance().getMenuID())) {
            適用解除日の存在性チェック(異動日, 解除日, 解除);
            解除期間が重複チェック(適用年月日, 解除日);
        }
    }

    /**
     * 介住所地特例異動チェック処理です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 適用日 FlexibleDate
     * @param 適用届出日 FlexibleDate
     * @param 適用事由コード RString
     * @param 解除日 FlexibleDate
     * @param 解除届出日 FlexibleDate
     * @param 解除事由コード RString
     * @return 登録フラッグ boolean
     */
    public boolean saveShikakuJutoku(
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 適用日,
            FlexibleDate 適用届出日,
            RString 適用事由コード,
            FlexibleDate 解除日,
            FlexibleDate 解除届出日,
            RString 解除事由コード) {
        HihokenshaShutokuJyoho hihokenshaShutokuJyoho = hihokenshaShikakuShutoku.getSaishinDeta(識別コード, 被保険者番号);
        DbT1001HihokenshaDaichoEntity 登録用Entity = new DbT1001HihokenshaDaichoEntity();
        登録用Entity.setHihokenshaNo(hihokenshaShutokuJyoho.get被保険者番号());
        登録用Entity.setShichosonCode(hihokenshaShutokuJyoho.get市町村コード());
        登録用Entity.setShikibetsuCode(hihokenshaShutokuJyoho.get識別コード());
        登録用Entity.setShikakuShutokuJiyuCode(hihokenshaShutokuJyoho.get資格取得事由コード());
        登録用Entity.setShikakuShutokuYMD(hihokenshaShutokuJyoho.get資格取得年月日());
        登録用Entity.setShikakuShutokuTodokedeYMD(hihokenshaShutokuJyoho.get資格取得届出年月日());
        登録用Entity.setIchigoShikakuShutokuYMD(hihokenshaShutokuJyoho.get第1号資格取得年月日());
        登録用Entity.setHihokennshaKubunCode(hihokenshaShutokuJyoho.get被保険者区分コード());
        登録用Entity.setShikakuSoshitsuJiyuCode(hihokenshaShutokuJyoho.get資格喪失事由コード());
        登録用Entity.setShikakuSoshitsuYMD(hihokenshaShutokuJyoho.get資格喪失年月日());
        登録用Entity.setShikakuSoshitsuTodokedeYMD(hihokenshaShutokuJyoho.get資格喪失届出年月日());
        登録用Entity.setShikakuHenkoJiyuCode(hihokenshaShutokuJyoho.get資格変更事由コード());
        登録用Entity.setShikakuHenkoYMD(hihokenshaShutokuJyoho.get資格変更年月日());
        登録用Entity.setShikakuHenkoTodokedeYMD(hihokenshaShutokuJyoho.get資格変更届出年月日());
        登録用Entity.setKoikinaiJushochiTokureiFlag(hihokenshaShutokuJyoho.get広域内住所地特例フラグ());
        登録用Entity.setKoikinaiTokureiSochimotoShichosonCode(hihokenshaShutokuJyoho.get広住特措置元市町村コード());
        登録用Entity.setKyuShichosonCode(hihokenshaShutokuJyoho.get旧市町村コード());
        登録用Entity.setLogicalDeletedFlag(hihokenshaShutokuJyoho.is論理削除フラグ());

        if (ShikakuJutokuTekiyoJiyu.自特例適用.getコード().equals(適用事由コード)) {
            登録用Entity = 適用処理のデータ編集(登録用Entity, hihokenshaShutokuJyoho, 適用日, 適用届出日, 適用事由コード);
        }
        if (ShikakuJutokuKaijoJiyu.自特例解除.getコード().equals(解除事由コード)
                || ShikakuJutokuKaijoJiyu.自特例転入.getコード().equals(解除事由コード)) {
            登録用Entity = 解除処理のデータ編集(登録用Entity, hihokenshaShutokuJyoho, 解除日, 解除届出日, 解除事由コード);
        }
        RString edaban = HihokenshaShikakuShutokuManager.createInstance().getSaidaiEdaban(
                hihokenshaShutokuJyoho.get被保険者番号(), hihokenshaShutokuJyoho.get異動日());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(登録用Entity);
        HihokenshaDaichoBuilder hihokenshaDaichoBuilder = hihokenshaDaicho.createBuilderForEdit();
        hihokenshaDaichoBuilder.set枝番(edaban);
        hihokenshaDaicho = hihokenshaDaichoBuilder.build();
        if (hihokenshaDaicho.get被保険者番号() == null || hihokenshaDaicho.get異動日() == null || RString.isNullOrEmpty(hihokenshaDaicho.get枝番())) {
            return false;
        }
        if (hihokenshaDaichoDac.selectByKey(hihokenshaDaicho.get被保険者番号(), hihokenshaDaicho.get異動日(), hihokenshaDaicho.get枝番()) == null) {
            return hihokenshaDaichoDac.insert(hihokenshaDaicho.toEntity()) == 1;
        }
        return false;
    }

    private DbT1001HihokenshaDaichoEntity 適用処理のデータ編集(
            DbT1001HihokenshaDaichoEntity 登録用Entity,
            HihokenshaShutokuJyoho hihokenshaShutokuJyoho,
            FlexibleDate 適用日,
            FlexibleDate 適用届出日,
            RString 適用事由コード) {
        登録用Entity.setIdoYMD(適用日);
        登録用Entity.setIdoJiyuCode(適用事由コード);
        登録用Entity.setJushochitokureiTekiyoJiyuCode(適用事由コード);
        登録用Entity.setJushochitokureiTekiyoYMD(適用日);
        登録用Entity.setJushochitokureiTekiyoTodokedeYMD(適用届出日);
        登録用Entity.setJushochitokureiKaijoJiyuCode(hihokenshaShutokuJyoho.get住所地特例解除事由コード());
        登録用Entity.setJushochitokureiKaijoYMD(hihokenshaShutokuJyoho.get解除年月日());
        登録用Entity.setJushochitokureiKaijoTodokedeYMD(hihokenshaShutokuJyoho.get解除届出年月日());
        登録用Entity.setJushochiTokureiFlag(new RString("0"));
        return 登録用Entity;
    }

    private DbT1001HihokenshaDaichoEntity 解除処理のデータ編集(
            DbT1001HihokenshaDaichoEntity 登録用Entity,
            HihokenshaShutokuJyoho hihokenshaShutokuJyoho,
            FlexibleDate 解除日,
            FlexibleDate 解除届出日,
            RString 解除事由コード) {
        登録用Entity.setIdoYMD(解除日);
        登録用Entity.setIdoJiyuCode(解除事由コード);
        登録用Entity.setJushochitokureiTekiyoJiyuCode(hihokenshaShutokuJyoho.get住所地特例適用事由コード());
        登録用Entity.setJushochitokureiTekiyoYMD(hihokenshaShutokuJyoho.get適用年月日());
        登録用Entity.setJushochitokureiTekiyoTodokedeYMD(hihokenshaShutokuJyoho.get適用届出年月日());
        登録用Entity.setJushochitokureiKaijoJiyuCode(解除事由コード);
        登録用Entity.setJushochitokureiKaijoYMD(解除日);
        登録用Entity.setJushochitokureiKaijoTodokedeYMD(解除届出日);
        登録用Entity.setJushochiTokureiFlag(new RString("1"));
        return 登録用Entity;
    }

    private void 適用解除日の存在性チェック(FlexibleDate 異動日, FlexibleDate 適用解除日, RString 住所地特例Flag) {
        if (適用解除日 != null && !適用解除日.isEmpty()) {
            if (is期間チェック(適用解除日, 異動日) && new RString("適用").equals(住所地特例Flag)) {
                throw new ApplicationException(DbaErrorMessages.適用日以降新資格異動有り.getMessage());
            }
            if (is期間チェック(適用解除日, 異動日) && new RString("解除").equals(住所地特例Flag)) {
                throw new ApplicationException(DbaErrorMessages.解除日以降新資格異動有り.getMessage());
            }
        }
    }

    private void 適用期間が重複チェック(FlexibleDate 解除年月日, FlexibleDate 適用日) {
        if (解除年月日 == null && 適用日.isEmpty()) {
            throw new ApplicationException(DbaErrorMessages.適用日不正適用期間重複.getMessage());
        }
        if (解除年月日 != null && !適用日.isEmpty() && is期間チェック(適用日, 解除年月日)) {
            throw new ApplicationException(DbaErrorMessages.適用日不正適用期間重複.getMessage());
        }
    }

    private void 解除期間が重複チェック(FlexibleDate 適用年月日, FlexibleDate 解除日) {
        if (適用年月日.isEmpty() && 解除日.isEmpty()) {
            throw new ApplicationException(DbaErrorMessages.適用日不正適用期間重複.getMessage());
        }
        if (適用年月日.isEmpty() && !解除日.isEmpty() && is期間チェック(解除日, 適用年月日)) {
            throw new ApplicationException(DbaErrorMessages.適用日不正適用期間重複.getMessage());
        }
    }

    private boolean is期間チェック(FlexibleDate 期間日期, FlexibleDate 期間日期2) {
        return 期間日期.isBefore(期間日期2);
    }
}
