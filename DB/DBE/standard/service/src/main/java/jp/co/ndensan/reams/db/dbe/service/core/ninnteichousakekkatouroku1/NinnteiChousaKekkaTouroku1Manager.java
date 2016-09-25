package jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.NinnteiChousaKekkaTouroku1RelateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.NinnteiChousaKekkaTouroku1RowJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlagBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoChosaItemManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoGaikyoChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKihonChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKinyuItemManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoFlagManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoShisetsuRiyoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査結果登録1を管理するクラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public class NinnteiChousaKekkaTouroku1Manager {

    private static final RString 予防給付サービス_選択 = new RString("key0");
    private static final RString 介護給付サービス_選択 = new RString("key1");
    private static final RString なし_選択 = new RString("key2");
    private static final RString 住宅改修_有 = new RString("key0");
    private static final RString 住宅改修_無 = new RString("key1");
    private static final RString 在宅 = new RString("在宅");
    private static final RString 施設 = new RString("施設");
    private static final int 住宅改修_連番 = 1;
    private static final int 市町村特別給付_連番 = 1;
    private static final int 介護保険給付外の在宅サービス_連番 = 2;
    private static final RString 認定調査0回 = new RString("0");
    private static final RString 認定調査1回 = new RString("1");

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinnteiChousaKekkaTouroku1Manager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinnteiChousaKekkaTouroku1Manager}のインスタンス
     */
    public static NinnteiChousaKekkaTouroku1Manager createInstance() {
        return InstanceProvider.create(NinnteiChousaKekkaTouroku1Manager.class);
    }

    /**
     * DBの更新処理を行います。
     *
     * @param pageRelateJoho 画面データ
     */
    @Transaction
    public void 更新処理(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {

        if (ChosaKubun.新規調査.get名称().equals(pageRelateJoho.get調査区分()) && 認定調査0回.equals(pageRelateJoho.getTemp_認定調査回数())
                || ChosaKubun.新規調査.get名称().equals(pageRelateJoho.get調査区分()) && 認定調査1回.equals(pageRelateJoho.getTemp_認定調査回数())
                || ChosaKubun.再調査.get名称().equals(pageRelateJoho.get調査区分())) {

            現在の状況_在宅or施設の保存(pageRelateJoho);
            認定調査依頼情報の更新(pageRelateJoho);
            概況調査の更新(pageRelateJoho);
            サービス状況フラグの更新(pageRelateJoho);
            記入項目の更新(pageRelateJoho);
            調査項目の更新(pageRelateJoho);

            if (予防給付サービス_選択.toString().equalsIgnoreCase(pageRelateJoho.get現在のサービス区分().toString())) {
                介護給付サービス状況のクリア(pageRelateJoho);
                予防給付サービス状況の更新(pageRelateJoho);
            } else if (介護給付サービス_選択.toString().equalsIgnoreCase(pageRelateJoho.get現在のサービス区分().toString())) {
                予防給付サービス状況のクリア(pageRelateJoho);
                介護給付サービス状況の更新(pageRelateJoho);
            } else if (なし_選択.toString().equalsIgnoreCase(pageRelateJoho.get現在のサービス区分().toString())) {
                予防給付サービス状況のクリア(pageRelateJoho);
                介護給付サービス状況のクリア(pageRelateJoho);
            }

            if (施設.equals(pageRelateJoho.get現在の概況調査場所())) {
                施設利用の更新(pageRelateJoho);
            } else if (!施設.equals(pageRelateJoho.get現在の概況調査場所())) {
                施設利用falseの設定(pageRelateJoho);
            }
        }
    }

    private void 認定調査依頼情報の更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();

        NinteichosaIraiJohoManager dbt5201Manager = NinteichosaIraiJohoManager.createInstance();
        NinteichosaIraiJoho dbt5201 = dbt5201Manager.get認定調査依頼情報(temp_申請書管理番号, temp_認定調査履歴番号);
        if (dbt5201 == null) {
            dbt5201 = new NinteichosaIraiJoho(temp_申請書管理番号, temp_認定調査履歴番号);
        }
        NinteichosaIraiJohoBuilder dbt5201Bulid = dbt5201.createBuilderForEdit();
        dbt5201Bulid.set認定調査回数(1);
        dbt5201Manager.save認定調査依頼情報(dbt5201Bulid.build());
    }

    private void 概況調査の更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();

        RString 概況調査テキストイメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate());
        NinteichosahyoGaikyoChosaManager dbt5202Manager = new NinteichosahyoGaikyoChosaManager();
        NinteichosahyoGaikyoChosa dbt5202 = dbt5202Manager.get認定調査票_概況調査_子(temp_申請書管理番号, temp_認定調査履歴番号, 概況調査テキストイメージ区分);
        if (dbt5202 == null) {
            dbt5202 = new NinteichosahyoGaikyoChosa(temp_申請書管理番号, temp_認定調査履歴番号, 概況調査テキストイメージ区分);
        }
        NinteichosahyoGaikyoChosaBuilder dbt5202builder = dbt5202.createBuilderForEdit();
        dbt5202builder.set厚労省IF識別コード(new Code(pageRelateJoho.getTemp_厚労省IF識別コード()));
        dbt5202builder.set認定調査依頼区分コード(pageRelateJoho.get認定調査依頼区分コード());
        dbt5202builder.set認定調査回数(1);
        dbt5202builder.set認定調査実施年月日(pageRelateJoho.get認定調査実施年月日());
        dbt5202builder.set認定調査受領年月日(FlexibleDate.getNowDate());
        dbt5202builder.set認定調査区分コード(pageRelateJoho.get認定調査区分コード());
        dbt5202builder.set認定調査委託先コード(pageRelateJoho.get認定調査委託先コード());
        dbt5202builder.set認定調査員コード(pageRelateJoho.get認定調査員コード());
        dbt5202builder.set認定調査実施場所コード(pageRelateJoho.get認定調査実施場所コード());
        dbt5202builder.set認定調査実施場所名称(pageRelateJoho.get認定調査実施場所名称());
        dbt5202builder.set認定調査_サービス区分コード(pageRelateJoho.get認定調査_サービス区分コード());
        dbt5202builder.set利用施設名(pageRelateJoho.get利用施設名());
        dbt5202builder.set利用施設住所(pageRelateJoho.get利用施設住所());
        dbt5202builder.set利用施設電話番号(pageRelateJoho.get利用施設電話番号());
        dbt5202builder.set利用施設郵便番号(pageRelateJoho.get利用施設郵便番号());
        dbt5202builder.set特記(pageRelateJoho.get特記());
        dbt5202builder.set認定調査特記事項受付年月日(new FlexibleDate(RString.EMPTY));
        dbt5202builder.set認定調査特記事項受領年月日(new FlexibleDate(RString.EMPTY));
        dbt5202Manager.save認定調査票_概況調査_子(dbt5202builder.build());
    }

    private void サービス状況フラグの更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        RString 住宅改修 = pageRelateJoho.get住宅改修();
        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();
        RString temp_厚労省IF識別コード = pageRelateJoho.getTemp_厚労省IF識別コード();

        NinteichosahyoServiceJokyoFlagManager dbt5208Manager = new NinteichosahyoServiceJokyoFlagManager();
        NinteichosahyoServiceJokyoFlag dbt5208 = dbt5208Manager.
                get認定調査票_概況調査_サービスの状況フラグ(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        if (dbt5208 == null) {
            dbt5208 = new NinteichosahyoServiceJokyoFlag(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        }
        NinteichosahyoServiceJokyoFlagBuilder dbt5208Builder = dbt5208.createBuilderForEdit();
        dbt5208Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        if (住宅改修_有.equals(住宅改修)) {
            dbt5208Builder.setサービスの状況フラグ(Boolean.TRUE);
        } else if (住宅改修_無.equals(住宅改修)) {
            dbt5208Builder.setサービスの状況フラグ(Boolean.FALSE);
        }
        dbt5208Manager.save認定調査票_概況調査_サービスの状況フラグ(dbt5208Builder.build());
    }

    private void 記入項目の更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {

        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();
        RString temp_厚労省IF識別コード = pageRelateJoho.getTemp_厚労省IF識別コード();
        NinteichosahyoKinyuItemManager dbt5209Manager = new NinteichosahyoKinyuItemManager();
        NinteichosahyoKinyuItem dbt5209 = dbt5209Manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 市町村特別給付_連番);
        if (dbt5209 == null) {
            dbt5209 = new NinteichosahyoKinyuItem(temp_申請書管理番号, temp_認定調査履歴番号, 市町村特別給付_連番);
        }
        NinteichosahyoKinyuItemBuilder dbt5209Builder = dbt5209.createBuilderForEdit();
        dbt5209Builder.setサービスの状況記入(pageRelateJoho.get市町村特別給付TXT());
        dbt5209Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5209Manager.save認定調査票_概況調査_記入項目(dbt5209Builder.build());

        dbt5209 = dbt5209Manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 介護保険給付外の在宅サービス_連番);
        if (dbt5209 == null) {
            dbt5209 = new NinteichosahyoKinyuItem(temp_申請書管理番号, temp_認定調査履歴番号, 介護保険給付外の在宅サービス_連番);
        }
        dbt5209Builder = dbt5209.createBuilderForEdit();
        dbt5209Builder.setサービスの状況記入(pageRelateJoho.get介護保険給付以外の在宅サービスTXT());
        dbt5209Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5209Manager.save認定調査票_概況調査_記入項目(dbt5209Builder.build());
    }

    private void 施設利用の更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {

        List<Integer> 施設利用連番List = pageRelateJoho.get施設利用連番List();
        List<NinnteiChousaKekkaTouroku1RowJoho> shisetsuList = pageRelateJoho.getShisetsuList();

        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();
        RString temp_厚労省IF識別コード = pageRelateJoho.getTemp_厚労省IF識別コード();

        NinteichosahyoShisetsuRiyoManager dbt5210Manager = new NinteichosahyoShisetsuRiyoManager();
        int index = 0;
        int 連番;
        for (NinnteiChousaKekkaTouroku1RowJoho row : shisetsuList) {
            連番 = 施設利用連番List.get(index++);
            NinteichosahyoShisetsuRiyo dbt5210 = dbt5210Manager.get認定調査票_概況調査_施設利用(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5210 == null) {
                dbt5210 = new NinteichosahyoShisetsuRiyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoShisetsuRiyoBuilder dbt5210Builder = dbt5210.createBuilderForEdit();
            dbt5210Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5210Builder.set施設利用フラグ(row.get施設利用フラグ());
            dbt5210Manager.save認定調査票_概況調査_施設利用(dbt5210Builder.build());
        }
    }

    private void 施設利用falseの設定(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {

        List<Integer> 施設利用連番List = pageRelateJoho.get施設利用連番List();

        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();
        RString temp_厚労省IF識別コード = pageRelateJoho.getTemp_厚労省IF識別コード();

        NinteichosahyoShisetsuRiyoManager dbt5210Manager = new NinteichosahyoShisetsuRiyoManager();
        for (Integer 連番 : 施設利用連番List) {
            NinteichosahyoShisetsuRiyo dbt5210 = dbt5210Manager.get認定調査票_概況調査_施設利用(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5210 == null) {
                dbt5210 = new NinteichosahyoShisetsuRiyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoShisetsuRiyoBuilder dbt5210Builder = dbt5210.createBuilderForEdit();
            dbt5210Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5210Builder.set施設利用フラグ(Boolean.FALSE);
            dbt5210Manager.save認定調査票_概況調査_施設利用(dbt5210Builder.build());
        }
    }

    private void 現在の状況_在宅or施設の保存(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        RString 調査場所 = pageRelateJoho.get調査場所();

        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();
        RString temp_厚労省IF識別コード = pageRelateJoho.getTemp_厚労省IF識別コード();

        int 居宅連番 = 1;
        NinteichosahyoShisetsuRiyoManager dbt5210Manager = new NinteichosahyoShisetsuRiyoManager();
        NinteichosahyoShisetsuRiyo dbt5210 = dbt5210Manager.get認定調査票_概況調査_施設利用(temp_申請書管理番号, temp_認定調査履歴番号, 居宅連番);
        if (dbt5210 == null) {
            dbt5210 = new NinteichosahyoShisetsuRiyo(temp_申請書管理番号, temp_認定調査履歴番号, 居宅連番);
        }
        NinteichosahyoShisetsuRiyoBuilder dbt5210Builder = dbt5210.createBuilderForEdit();
        dbt5210Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));

        if (在宅.equals(調査場所)) {
            dbt5210Builder.set施設利用フラグ(Boolean.TRUE);
        } else if (施設.equals(調査場所)) {
            dbt5210Builder.set施設利用フラグ(Boolean.FALSE);
        }
        dbt5210Manager.save認定調査票_概況調査_施設利用(dbt5210Builder.build());
    }

    private void 調査項目の更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        基本調査第1群更新(pageRelateJoho);
        基本調査第2群更新(pageRelateJoho);
        基本調査第3群更新(pageRelateJoho);
        基本調査第4群更新(pageRelateJoho);
        基本調査第5群更新(pageRelateJoho);
        基本調査第6群更新(pageRelateJoho);
        基本調査第7群更新(pageRelateJoho);
    }

    private void 基本調査第1群更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {

        ArrayList<KihonChosaInput> 第1群List = pageRelateJoho.get第1群List();
        if (第1群List == null || 第1群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第1群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目(), pageRelateJoho);
        }
    }

    private void 基本調査第2群更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        ArrayList<KihonChosaInput> 第2群List = pageRelateJoho.get第2群List();
        if (第2群List == null || 第2群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第2群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目(), pageRelateJoho);
        }
    }

    private void 基本調査第3群更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        ArrayList<KihonChosaInput> 第3群List = pageRelateJoho.get第3群List();
        if (第3群List == null || 第3群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第3群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目(), pageRelateJoho);
        }
    }

    private void 基本調査第4群更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        ArrayList<KihonChosaInput> 第4群List = pageRelateJoho.get第4群List();
        if (第4群List == null || 第4群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第4群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目(), pageRelateJoho);
        }
    }

    private void 基本調査第5群更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        ArrayList<KihonChosaInput> 第5群List = pageRelateJoho.get第5群List();
        if (第5群List == null || 第5群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第5群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目(), pageRelateJoho);
        }
    }

    private void 基本調査第6群更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        ArrayList<KihonChosaInput> 第6群List = pageRelateJoho.get第6群List();
        if (第6群List == null || 第6群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第6群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目(), pageRelateJoho);
        }
    }

    private void 基本調査第7群更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {

        ArrayList<KihonChosaInput> 第7群List = pageRelateJoho.get第7群List();
        if (第7群List == null || 第7群List.isEmpty()) {
            return;
        }

        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();
        RString temp_厚労省IF識別コード = pageRelateJoho.getTemp_厚労省IF識別コード();

        NinteichosahyoKihonChosaManager manager = new NinteichosahyoKihonChosaManager();

        Code 障害高齢者の日常生活自立度コード = 第7群List.get(0).get障害高齢者自立度();
        Code 認知症高齢者の日常生活自立度コード = 第7群List.get(1).get認知症高齢者自立度();

        NinteichosahyoKihonChosa dbt5203 = manager.get認定調査票_基本調査(temp_申請書管理番号, temp_認定調査履歴番号);
        if (dbt5203 == null) {
            dbt5203 = new NinteichosahyoKihonChosa(temp_申請書管理番号, temp_認定調査履歴番号);
        }
        NinteichosahyoKihonChosaBuilder builder = dbt5203.createBuilderForEdit();
        builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        builder.set認定調査_障害高齢者の日常生活自立度コード(障害高齢者の日常生活自立度コード);
        builder.set認定調査_認知症高齢者の日常生活自立度コード(認知症高齢者の日常生活自立度コード);
        manager.save認定調査票_基本調査(builder.build());
    }

    private void 調査項目の保存(int 連番, RString 調査項目, NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {

        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();
        RString temp_厚労省IF識別コード = pageRelateJoho.getTemp_厚労省IF識別コード();

        NinteichosahyoChosaItemManager manager = new NinteichosahyoChosaItemManager();
        NinteichosahyoChosaItem dbt5211 = manager.get認定調査票_基本調査_調査項目(temp_申請書管理番号, temp_認定調査履歴番号, 連番);

        if (dbt5211 == null) {
            dbt5211 = new NinteichosahyoChosaItem(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
        }
        NinteichosahyoChosaItemBuilder builder = dbt5211.createBuilderForEdit();
        builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        builder.set調査項目(調査項目);
        manager.save認定調査票_基本調査_調査項目(builder.build());
    }

    private void 予防給付サービス状況の更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {

        List<Integer> 予防給付サービス連番List = pageRelateJoho.get予防給付サービス連番List();
        List<NinnteiChousaKekkaTouroku1RowJoho> firstHalf = pageRelateJoho.getFirstHalf();

        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();
        RString temp_厚労省IF識別コード = pageRelateJoho.getTemp_厚労省IF識別コード();

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        if (firstHalf == null) {
            return;
        }
        Decimal 利用状況;
        int index = 0;
        int 連番;
        for (NinnteiChousaKekkaTouroku1RowJoho firstRow : firstHalf) {
            利用状況 = firstRow.get利用状況();
            if (利用状況 == null || 利用状況.toString().isEmpty()) {
                利用状況 = new Decimal(0);
            }
            連番 = 予防給付サービス連番List.get(index++);
            NinteichosahyoServiceJokyo dbt5207 = dbt5207Manager.get認定調査票_概況調査_サービスの状況(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5207 == null) {
                dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5207Builder.setサービスの状況(利用状況.intValue());
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    private void 予防給付サービス状況のクリア(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        List<Integer> 予防給付サービス連番List = pageRelateJoho.get予防給付サービス連番List();

        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();
        RString temp_厚労省IF識別コード = pageRelateJoho.getTemp_厚労省IF識別コード();

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        for (Integer 連番 : 予防給付サービス連番List) {
            NinteichosahyoServiceJokyo dbt5207 = dbt5207Manager.get認定調査票_概況調査_サービスの状況(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5207 == null) {
                dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5207Builder.setサービスの状況(0);
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    private void 介護給付サービス状況の更新(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {

        List<Integer> 介護給付サービス連番List = pageRelateJoho.get介護給付サービス連番List();
        List<NinnteiChousaKekkaTouroku1RowJoho> secondHalf = pageRelateJoho.getSecondHalf();

        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();
        RString temp_厚労省IF識別コード = pageRelateJoho.getTemp_厚労省IF識別コード();

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        if (secondHalf == null) {
            return;
        }
        Decimal 利用状況;
        int index = 0;
        int 連番;
        for (NinnteiChousaKekkaTouroku1RowJoho secondRow : secondHalf) {
            利用状況 = secondRow.get利用状況();
            if (利用状況 == null || 利用状況.toString().isEmpty()) {
                利用状況 = new Decimal(0);
            }
            連番 = 介護給付サービス連番List.get(index++);
            NinteichosahyoServiceJokyo dbt5207 = dbt5207Manager.get認定調査票_概況調査_サービスの状況(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5207 == null) {
                dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5207Builder.setサービスの状況(利用状況.intValue());
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    private void 介護給付サービス状況のクリア(NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        List<Integer> 介護給付サービス連番List = pageRelateJoho.get介護給付サービス連番List();

        ShinseishoKanriNo temp_申請書管理番号 = pageRelateJoho.getTemp_申請書管理番号();
        int temp_認定調査履歴番号 = pageRelateJoho.getTemp_認定調査履歴番号();
        RString temp_厚労省IF識別コード = pageRelateJoho.getTemp_厚労省IF識別コード();

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        for (Integer 連番 : 介護給付サービス連番List) {
            NinteichosahyoServiceJokyo dbt5207 = dbt5207Manager.get認定調査票_概況調査_サービスの状況(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5207 == null) {
                dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5207Builder.setサービスの状況(0);
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

}
