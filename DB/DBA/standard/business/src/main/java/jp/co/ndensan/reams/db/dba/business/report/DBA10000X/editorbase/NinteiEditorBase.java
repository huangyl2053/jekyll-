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
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 被保険者証の、認定情報を編集するためのEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class NinteiEditorBase {

    private final HihokenshashoModel hihokenshashoModel;

    /**
     * コンストラクタです。引数から被保険者の情報を受け取ります。
     *
     * @param hihokenshashoModel 被保険者台帳情報
     */
    public NinteiEditorBase(HihokenshashoModel hihokenshashoModel) {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));

        this.hihokenshashoModel = hihokenshashoModel;
    }

    public void set要介護状態区分等(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 以下の項目に値を設定する。
        //source.kaigokbn1
    }

    public void set認定年月日(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 以下の項目に値を設定する。
        //source.ninteiymd1

    }

    public void set認定有効期間(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 以下の項目に値を設定する。
        //source.yukokikanst1
        //source.yukokikaned1
    }

    public void set居宅サービス(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 以下の項目に値を設定する。
        //source.homonkikanst1
        //source.homonkikaned1
        //source.servicetani1
        //source.service11
        //source.ten01
    }

    public void setうち種類支給限度基準額(IHihokenshashoCommonEditData source) {
        //TODO
        //1, HihokenshaShikakuHakkoの持つ、うち種類支給限度額のListを、サービス金額の降順でソートする。
        //2, ソートしたうち種類支給限度額の、1番目の情報を以下に設定する。
        //  source.shurui11 → サービス種類を設定
        //  source.shuruigendo11 → 種類基準限度額を設定
        //  source.ten11 → "単位"と印字
        //2, ソートしたうち種類支給限度額の、2番目の情報を以下に設定する。
        //  source.shurui21 → サービス種類を設定
        //  source.shuruigendo21 → 種類基準限度額を設定
        //  source.ten21 → "単位"と印字
        //2, ソートしたうち種類支給限度額の、3番目の情報を以下に設定する。
        //  source.shurui31 → サービス種類を設定
        //  source.shuruigendo31 → 種類基準限度額を設定
        //  source.ten31 → "単位"と印字
        //2, ソートしたうち種類支給限度額の、4番目の情報を以下に設定する。
        //  source.shurui41 → サービス種類を設定
        //  source.shuruigendo41 → 種類基準限度額を設定
        //  source.ten41 → "単位"と印字
        //2, ソートしたうち種類支給限度額の、5番目の情報を以下に設定する。
        //  source.shurui51 → サービス種類を設定
        //  source.shuruigendo51 → 種類基準限度額を設定
        //  source.ten51 → "単位"と印字
        //2, ソートしたうち種類支給限度額の、6番目の情報を以下に設定する。
        //  source.shurui61 → サービス種類を設定
        //  source.shuruigendo61 → 種類基準限度額を設定
        //  source.ten61 → "単位"と印字
    }

    public void set認定審査会の意見等(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 以下の項目に値を設定する。
        //source.ryui1
    }

}
