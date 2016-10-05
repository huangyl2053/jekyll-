/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE012001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosayoteimitei.ChosahyoIkenshoCheckListProcessParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosayoteimitei.NinteichosaIraiHenkoProcessParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosayoteimitei.NinteichosaYoteiMiteiProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 調査情報印刷のバッチパラメータクラスです。
 *
 * @reamsid_L DBE-1390-080 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBE012001_ChosaInfoPrintParameter extends BatchParameterBase {

    private static final String NINTEICHOSAYOTEIMITEI = "ninteichosayoteimitei";
    private static final String JOKEN1 = "joken1";
    private static final String YOTEIMITEIYMD_FROM = "yoteimiteiymdFrom";
    private static final String YOTEIMITEIYMD_TO = "yoteimiteiymdTo";
    private static final String NINTEICHOSAIJOKEN = "ninteichosaijoken";
    private static final String IRAISAKIHENKYMD_FROM = "iraisakihenkymdFrom";
    private static final String IRAISAKIHENKYMD_TO = "iraisakihenkymdTo";
    private static final String CHECKLIST_JOKEN = "checkListJoken";
    private static final String JOKEN3 = "joken3";
    private static final String CHECKLISTSHINSEIYMD_FROM = "checkListShinseiYMDFrom";
    private static final String CHECKLISTSHINSEIYMD_TO = "checkListShinseiYMDTo";
    private static final String SHINSAYMD = "shinsaYMD";
    private static final String SHINSAKAI = "shinsakai";
    private static final long serialVersionUID = 5835788479145553257L;

    @BatchParameter(key = NINTEICHOSAYOTEIMITEI, name = "認定調査予定未定者一覧フラグ")
    private boolean ninteichosayoteimitei;
    @BatchParameter(key = JOKEN1, name = "認定調査予定未定者一覧作成条件")
    private RString joken1;
    @BatchParameter(key = YOTEIMITEIYMD_FROM, name = "認定調査予定未定者一覧申請日From")
    private RString yoteimiteiymdFrom;
    @BatchParameter(key = YOTEIMITEIYMD_TO, name = "認定調査予定未定者一覧申請日To")
    private RString yoteimiteiymdTo;
    @BatchParameter(key = NINTEICHOSAIJOKEN, name = "認定調査依頼先変更者一覧表フラグ")
    private boolean ninteichosaijoken;
    @BatchParameter(key = IRAISAKIHENKYMD_FROM, name = "認定調査依頼先変更者一覧表申請日From")
    private RString iraisakihenkymdFrom;
    @BatchParameter(key = IRAISAKIHENKYMD_TO, name = "認定調査依頼先変更者一覧表申請日To")
    private RString iraisakihenkymdTo;
    @BatchParameter(key = CHECKLIST_JOKEN, name = "認定調査結果と主治医意見書のチェックリストフラグ")
    private boolean checkListJoken;
    @BatchParameter(key = JOKEN3, name = "認定調査結果と主治医意見書のチェックリスト作成条件")
    private RString joken3;
    @BatchParameter(key = CHECKLISTSHINSEIYMD_FROM, name = "認定調査結果と主治医意見書のチェックリスト申請日From")
    private RString checkListShinseiYMDFrom;
    @BatchParameter(key = CHECKLISTSHINSEIYMD_TO, name = "認定調査結果と主治医意見書のチェックリスト申請日To")
    private RString checkListShinseiYMDTo;
    @BatchParameter(key = SHINSAYMD, name = "認定調査結果と主治医意見書のチェックリスト審査日")
    private RString shinsaYMD;
    @BatchParameter(key = SHINSAKAI, name = "認定調査結果と主治医意見書のチェックリスト審査会")
    private RString shinsakai;

    /**
     * 認定調査予定未定者一覧表のMybatisパラメータークラス作成
     *
     * @return ItakusakiChosainIchiranMybitisParamter
     */
    public NinteichosaYoteiMiteiProcessParamter toNinteichosaYoteiMiteiParamter() {
        return new NinteichosaYoteiMiteiProcessParamter(yoteimiteiymdFrom,
                yoteimiteiymdTo,
                joken1);
    }

    /**
     * 認定調査依頼先変更者一覧表のMybatisパラメータークラス作成
     *
     * @return ItakusakiChosainIchiranMybitisParamter
     */
    public NinteichosaIraiHenkoProcessParamter toNinteichosaIraiHenkoParamter() {
        return new NinteichosaIraiHenkoProcessParamter(iraisakihenkymdFrom,
                iraisakihenkymdTo);
    }

    /**
     * 認定調査結果と主治医意見書のチェックリストのMybatisパラメータークラス作成
     *
     * @return ItakusakiChosainIchiranMybitisParamter
     */
    public ChosahyoIkenshoCheckListProcessParamter toChosahyoIkenshoCheckListParamter() {
        return new ChosahyoIkenshoCheckListProcessParamter(checkListShinseiYMDFrom,
                checkListShinseiYMDTo,
                shinsaYMD,
                shinsakai,
                joken3);
    }
}
