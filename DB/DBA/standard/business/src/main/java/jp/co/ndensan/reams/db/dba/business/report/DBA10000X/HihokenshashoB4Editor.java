/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.DBA10000X;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.DateOfBirthEditorB4Base;
import jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.GenderEditorB4Base;
import jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.KyufuSeigenEditorBase;
import jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.NinteiEditorBase;
import jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.SeiDoitsuShogaiEditorBase;
import jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.ShikakuKihonEditorBase;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.HihokenshashoB4PrintPosition;
import jp.co.ndensan.reams.db.dba.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.HihokenshashoB4;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.HihokenshashoB4LowerEditData;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.HihokenshashoB4UpperEditData;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.IHihokenshashoB4CommonEditData;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 被保険者証B4版に印字する情報を設定するEditorです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoB4Editor implements IHihokenshashoB4Editor {

    private final HihokenshashoModel hihokenshashoModel;
    private final ShikakuKihonEditorBase shikakuKihonEditor;
    private final NinteiEditorBase ninteiEditor;
    private final KyufuSeigenEditorBase kyufuSeigenEditor;
    private final SeiDoitsuShogaiEditorBase seiDoitsuEditor;
    private final GenderEditorB4Base genderEditor;
    private final DateOfBirthEditorB4Base dateOfBirthEditor;

    /**
     * コンストラクタです。引数から被保険者の情報を受け取ります。
     *
     * @param hihokenshashoModel 被保険者台帳情報
     * @throws IllegalArgumentException 引数が持つ印字位置が指定無しである場合
     * @throws NullPointerException 引数がnullの場合
     */
    public HihokenshashoB4Editor(HihokenshashoModel hihokenshashoModel) throws NullPointerException, IllegalArgumentException {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));
        check印字位置(hihokenshashoModel);

        this.hihokenshashoModel = hihokenshashoModel;
        this.shikakuKihonEditor = new ShikakuKihonEditorBase(hihokenshashoModel);
        this.ninteiEditor = new NinteiEditorBase(hihokenshashoModel);
        this.kyufuSeigenEditor = new KyufuSeigenEditorBase(hihokenshashoModel);
        this.seiDoitsuEditor = new SeiDoitsuShogaiEditorBase(hihokenshashoModel);
        this.genderEditor = new GenderEditorB4Base(hihokenshashoModel);
        this.dateOfBirthEditor = new DateOfBirthEditorB4Base(hihokenshashoModel);

    }

    private void check印字位置(HihokenshashoModel hihokenshashoModel) {
        switch (hihokenshashoModel.getPosition()) {
            case 指定無し:
                throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("印字位置が不正のため、Modelを帳票ソースデータ"));
            default:
        }
    }

    @Override
    public HihokenshashoB4 edit(HihokenshashoB4 source) {
        IHihokenshashoB4CommonEditData editData;
        switch (hihokenshashoModel.getPosition()) {
            case 上部:
                editData = new HihokenshashoB4UpperEditData(source);
                break;
            default:
                editData = new HihokenshashoB4LowerEditData(source);
                break;
        }

        set資格基本情報(editData);
        set認定(editData);
        set給付制限(editData);
        set性同一障害(editData);
        set性別(editData);
        set生年月日(editData);
        return editData.getEditData();
    }

    private void set資格基本情報(IHihokenshashoCommonEditData source) {
        shikakuKihonEditor.set被保険者証有効期限(source);
        shikakuKihonEditor.set被保険者番号(source);
        shikakuKihonEditor.set住所(source);
        shikakuKihonEditor.set被保険者名(source);
        shikakuKihonEditor.set交付日(source);
        shikakuKihonEditor.set再交付情報(source);
        shikakuKihonEditor.set保険者番号(source);
        shikakuKihonEditor.set交付連番(source);
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
        kyufuSeigenEditor.set居宅介護支援事業者(source);
        kyufuSeigenEditor.set介護保険施設等(source);
    }

    private void set性同一障害(IHihokenshashoCommonEditData source) {
        seiDoitsuEditor.set性同一障害考慮(source);
    }

    private void set性別(IHihokenshashoB4CommonEditData source) {
        genderEditor.set性別(source);
    }

    private void set生年月日(IHihokenshashoB4CommonEditData source) {
        dateOfBirthEditor.set生年月日(source);
    }

    public HihokenshashoB4PrintPosition get印字位置() {
        return hihokenshashoModel.getPosition();
    }
}
