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
 * 被保険者証の、性同一障害について編集を行うEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class SeiDoitsuShogaiEditorBase {

    private final HihokenshashoModel hihokenshashoModel;

    /**
     * コンストラクタです。引数から被保険者の情報を受け取ります。
     *
     * @param hihokenshashoModel 被保険者台帳情報
     */
    public SeiDoitsuShogaiEditorBase(HihokenshashoModel hihokenshashoModel) {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));

        this.hihokenshashoModel = hihokenshashoModel;
    }

    public void set性同一障害考慮(IHihokenshashoCommonEditData source) {
        //TODO
        //1, 以下を設定する。
        //source.seiShogai11 - "3枚目の"を文字列で設定する。
        //source.seiShogai21 - "下段参照"を文字列で設定する。
        //source.kosekiSeibetsu11 - "戸籍上の"を文字列で設定する。
        //source.kosekiSeibetsu21 -  "性別："+戸籍上の性別を文字列で設定する。
    }

}
