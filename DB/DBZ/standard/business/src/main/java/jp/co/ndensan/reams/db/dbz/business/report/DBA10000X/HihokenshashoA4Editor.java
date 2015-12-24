/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.jushohenshu.ChohyoKyotsuJushoEditConfig;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoJushoEditConfig;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.DateOfBirthEditorA4Base;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.GenderEditorA4Base;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.KyufuSeigenEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.NamisenEditorA4Base;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.NinteiEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.SeiDoitsuShogaiEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.ShikakuKihonEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.NinteiAndKyotakuShienOutputChecker;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 被保険者証A4版に印字する情報を設定するEditorです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoA4Editor implements IHihokenshashoA4Editor {

    private final HihokenshashoPrintConfig printConfig;
    private final HihokenshashoJushoEditConfig hihoJushoEditConfig;
    private final ChohyoKyotsuJushoEditConfig kyotsuJushoEditConfig;

    private final ShikakuKihonEditorBase shikakuKihonEditor;
    private final NinteiEditorBase ninteiEditor;
    private final KyufuSeigenEditorBase kyufuSeigenEditor;
    private final SeiDoitsuShogaiEditorBase seiDoitsuEditor;
    private final GenderEditorA4Base genderEditor;
    private final DateOfBirthEditorA4Base dateOfBirthEditor;
    private final NamisenEditorA4Base namisenEditor;

    private final NinteiAndKyotakuShienOutputChecker checker;

    /**
     * コンストラクタです。引数から被保険者の情報を受け取ります。
     *
     * @param hihokenshashoModel 被保険者台帳情報
     * @param association 導入団体情報
     * @throws NullPointerException 引数がnullの場合
     */
    public HihokenshashoA4Editor(HihokenshashoModel hihokenshashoModel, Association association) throws NullPointerException {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));
        requireNonNull(association, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("全国住所", getClass().getName()));

        printConfig = new HihokenshashoPrintConfig();
        hihoJushoEditConfig = new HihokenshashoJushoEditConfig();
        kyotsuJushoEditConfig = new ChohyoKyotsuJushoEditConfig();

        this.shikakuKihonEditor = new ShikakuKihonEditorBase(
                hihokenshashoModel, association, 
                printConfig, hihoJushoEditConfig, kyotsuJushoEditConfig);
        this.ninteiEditor = new NinteiEditorBase(hihokenshashoModel);
        this.kyufuSeigenEditor = new KyufuSeigenEditorBase(hihokenshashoModel, printConfig);
        this.seiDoitsuEditor = new SeiDoitsuShogaiEditorBase(hihokenshashoModel);
        this.genderEditor = new GenderEditorA4Base(hihokenshashoModel);
        this.dateOfBirthEditor = new DateOfBirthEditorA4Base(hihokenshashoModel);
        this.namisenEditor = new NamisenEditorA4Base();

        checker = new NinteiAndKyotakuShienOutputChecker(hihokenshashoModel, printConfig);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param printConfig 被保険者証表示方法コンフィグMock
     * @param hihoJushoEditConfig 被保険者証住所編集方法コンフィグMock
     * @param kyotsuJushoEditConfig 帳票共通住所編集方法コンフィグMock
     * @param shikakuKihonEditor 資格基本EditorBaseMock
     * @param ninteiEditor 認定EditorBaseMock
     * @param kyufuSeigenEditor 給付制限EditorBaseMock
     * @param seiDoitsuEditor 性同一EditorBaseMock
     * @param genderEditor 性別EditorBaseMock
     * @param dateOfBirthEditor 生年月日EditorBaseMock
     * @param checker 認定・居宅支援情報表示Checker
     */
    HihokenshashoA4Editor(HihokenshashoPrintConfig printConfig, 
            HihokenshashoJushoEditConfig hihoJushoEditConfig, ChohyoKyotsuJushoEditConfig kyotsuJushoEditConfig,
            ShikakuKihonEditorBase shikakuKihonEditor, NinteiEditorBase ninteiEditor, KyufuSeigenEditorBase kyufuSeigenEditor,
            SeiDoitsuShogaiEditorBase seiDoitsuEditor, GenderEditorA4Base genderEditor, DateOfBirthEditorA4Base dateOfBirthEditor,
            NinteiAndKyotakuShienOutputChecker checker) {
        this.printConfig = printConfig;
        this.hihoJushoEditConfig = hihoJushoEditConfig;
        this.kyotsuJushoEditConfig = kyotsuJushoEditConfig;

        this.shikakuKihonEditor = shikakuKihonEditor;
        this.ninteiEditor = ninteiEditor;
        this.kyufuSeigenEditor = kyufuSeigenEditor;
        this.seiDoitsuEditor = seiDoitsuEditor;
        this.genderEditor = genderEditor;
        this.dateOfBirthEditor = dateOfBirthEditor;
        this.namisenEditor = new NamisenEditorA4Base();

        this.checker = checker;
    }

    @Override
    public HihokenshashoA4 edit(HihokenshashoA4 source) {
        IHihokenshashoA4CommonEditData editData = new HihokenshashoA4EditData(source);

        set資格基本情報(editData);
        if (checker.is認定情報表示()) {
            set認定(editData);
            set給付制限(editData);
            set波線(editData);
        }
        set性同一障害(editData);
        set性別(editData);
        set生年月日(editData);
        return editData.getEditData();
    }

    private void set資格基本情報(IHihokenshashoCommonEditData source) {
        shikakuKihonEditor.set被保険者番号(source);
        shikakuKihonEditor.set住所(source);
        shikakuKihonEditor.set被保険者名(source);
        shikakuKihonEditor.set交付日(source);
        shikakuKihonEditor.set再交付情報(source);
        shikakuKihonEditor.set保険者番号(source);
    }

    private void set認定(IHihokenshashoCommonEditData source) {
        ninteiEditor.set要介護状態区分等(source);
        ninteiEditor.set認定年月日(source);
        ninteiEditor.set認定有効期間(source);
        ninteiEditor.set居宅サービス(source);
        ninteiEditor.setうち種類支給限度基準額(source);
        ninteiEditor.set認定審査会の意見等(source);
    }

    private void set給付制限(IHihokenshashoCommonEditData source) {
        kyufuSeigenEditor.set給付制限(source);
        if (checker.is居宅支援事業者表示()) {
            kyufuSeigenEditor.set居宅介護支援事業者(source);
        }
        kyufuSeigenEditor.set介護保険施設等(source);
    }

    private void set性同一障害(IHihokenshashoCommonEditData source) {
        seiDoitsuEditor.set性同一障害考慮(source);
    }

    private void set性別(IHihokenshashoA4CommonEditData source) {
        genderEditor.set性別(source);
    }

    private void set生年月日(IHihokenshashoA4CommonEditData source) {
        dateOfBirthEditor.set生年月日(source);
    }

    private void set波線(IHihokenshashoA4CommonEditData source) {
        namisenEditor.set波線(source);
    }
}
