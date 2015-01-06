/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dba.business.report.DBA10000X.*;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.HihokenshashoB4;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;

/**
 * 被保険者証の被保険者資格基本情報について編集を行うEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuKihonEditorBase {

    private final HihokenshashoModel hihokenshashoModel;

    /**
     * コンストラクタです。引数から被保険者の情報を受け取ります。
     *
     * @param hihokenshashoModel 被保険者台帳情報
     */
    public ShikakuKihonEditorBase(HihokenshashoModel hihokenshashoModel) {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));

        this.hihokenshashoModel = hihokenshashoModel;
    }

    public void set被保険者証有効期限(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 以下の項目に値を設定する。
        //source.yukokigen1
        //source.yukokigen21
    }

    public void set被保険者番号(IHihokenshashoCommonEditData source) {
        //TODO
        //1, DBA業務コンフィグ：被保険者証表示方法_被保険者番号表示書式の値を取得する。
        //2, 被保険者番号表示書式の値が1である場合、source.hihokenshanno1に対して被保険者番号を、前ゼロを全て空白に編集した形で設定する。
        //3, 被保険者番号表示書式の値が2である場合、source.hihokenshanno1に対して被保険者番号を、前ゼロをそのままで設定する。
    }

    public void set住所(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 以下の項目に値を設定する。
        //
        //2, DBA業務コンフィグ：被保険者証表示方法_郵便番号表示有無の値が1である場合、以下の項目に値を設定する。
        //source.yubinno1
        //3, さらに、yubinno1に設定される値に対して、以下のような編集を行う。
        //  3-1, 郵便番号の値が空である場合、EMPTYとなる。
        //  3-2, 郵便番号の値が3桁である場合、郵便番号は[XXX]と編集。
        //  3-3, 郵便番号の値が5桁である場合、郵便番号は[XXX-XX]と編集。
        //  3-4, 郵便番号の値が7桁である場合、郵便番号は[XXX-XXXX]と編集。
        //
        //4, 以下の業務コンフィグを取得する。
        //  DBA業務コンフィグ
        //      被保険者証表示方法_管内住所編集_帳票独自区分
        //      被保険者証表示方法_管内住所編集_都道府県名付与有無
        //      被保険者証表示方法_管内住所編集_群名付与有無
        //      被保険者証表示方法_管内住所編集_市町村名付与有無
        //      被保険者証表示方法_管内住所編集_編集方法
        //      被保険者証表示方法_管内住所編集_方書表示有無
        //  DBU業務コンフィグ
        //      帳票共通住所編集方法_管内住所編集_都道府県名付与有無
        //      帳票共通住所編集方法_管内住所編集_群名付与有無
        //      帳票共通住所編集方法_管内住所編集_市町村名付与有無
        //      帳票共通住所編集方法_管内住所編集_編集方法
        //      帳票共通住所編集方法_管内住所編集_方書表示有無
        //
        //5, 被保険者証表示方法_管内住所編集_帳票独自区分が1の場合、編集方法としてDBA業務コンフィグを
        //   帳票独自区分が0の場合は、編集方法としてDBU業務コンフィグを使用する。
        //
        //6, 5で決定した編集方法を元に以下の値を設定する。
        //  6-1, 編集方法の値が2か3のいずれかである場合、以下の値を設定する。
        //      source.gyoseiku1
        //      source.gyoseikuS1
        //  6-2, source.hihojusho1に設定する情報を以下のように編集する。
        //      6-2-1, 都道府県名付与有無
        //          6-2-1-1, 都道府県名付与有無が1の場合、住所に都道府県の情報が追加される。
        //          6-2-1-2, 都道府県名付与有無が0の場合、住所に都道府県の情報を付与しない。
        //      6-2-2, 群名付与有無
        //          6-2-2-1, 群名付与有無が1の場合、住所に群名の情報が追加される。
        //          6-2-2-2, 群名付与有無が0の場合、住所に群名の情報を付与しない。
        //      6-2-3, 市町村名付与有無
        //          6-2-3-1, 市町村名付与有無が1の場合、住所に市町村名の情報が追加される。
        //          6-2-3-2, 市町村名付与有無が0の場合、住所に市町村名の情報を付与しない。
        //      6-2-4, 編集方法
        //          6-2-4-1, 編集方法が1の場合、[住所＋番地]というように住所を編集する。
        //          6-2-4-2, 編集方法が2の場合、[行政区＋番地]というように住所を編集する。
        //          6-2-4-3, 編集方法が3の場合、[住所＋番地、（行政区）]というように住所を編集する。
        //          6-2-4-4, 編集方法が4の場合、[番地]のみを住所に持つ。
        //          6-2-4-5, 編集方法が5の場合、住所は印字されない（EMPTYになる）。
        //      6-2-5, 方書表示有無
        //          6-2-5-1, 方書表示有無が1の場合、住所に方書の情報が追加される。
        //          6-2-5-2, 方書表示有無が0の場合、住所に方書の情報を付与しない。
    }

    public void set被保険者名(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 以下の項目に値を設定する。
        //source.hihoname1
        //2, DBA業務コンフィグ：被保険者証表示方法_氏名カナ表示有無の値を確認して、値が1だったら以下の項目に値を設定する。
        //source.hihokana1
    }

    public void set交付日(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 以下の項目に交付年月日を設定する。交付年月日は和暦で設定する。
        //source.kofuymdGengo1
        //source.kofuymdYy1
        //source.kofuymdMm1
        //source.kofuymdDd1
    }

    public void set再交付情報(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 証発行の事由が再交付である場合、以下の項目に対して"再交付"を設定する。
        //source.saikofu11
        //source.saikofu21
        //2, 事由が再交付以外である場合、何も行わない。
    }

    public void set保険者番号(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 以下の項目に対して保険者番号を設定する。
        //source.hokenshano11 - 保険者番号の1桁目を設定
        //source.hokenshano21 - 保険者番号の2桁目を設定
        //source.hokenshano31 - 保険者番号の3桁目を設定
        //source.hokenshano41 - 保険者番号の4桁目を設定
        //source.hokenshano51 - 保険者番号の5桁目を設定
        //source.hokenshano61 - 保険者番号の6桁目を設定
    }

    public void set交付連番(IHihokenshashoCommonEditData source) {
        //1, 以下の項目に、帳票交付連番を設定する。
        //source.renban1
    }

}
