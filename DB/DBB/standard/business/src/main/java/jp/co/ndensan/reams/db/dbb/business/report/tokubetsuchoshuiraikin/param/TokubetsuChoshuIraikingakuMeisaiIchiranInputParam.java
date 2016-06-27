/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.param;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表の入力パラメータ
 *
 * @reamsid_L DBB-0880-080 zhangrui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuIraikingakuMeisaiIchiranInputParam {

    private final KariTokuchoKaishiTsuchisyoJoho 通知書情報;
    private final RYear 調定年度;
    private final YMDHMS 帳票作成日時;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;
    private final Association association;

    /**
     * コンストラクタです。
     *
     * @param tsuchisyoJoho KariTokuchoKaishiTsuchisyoJoho
     * @param 調定年度 RString
     * @param 帳票作成日時 RString
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     * @param 改頁項目List List<RString>
     * @param association Association
     */
    public TokubetsuChoshuIraikingakuMeisaiIchiranInputParam(KariTokuchoKaishiTsuchisyoJoho tsuchisyoJoho,
            RYear 調定年度, YMDHMS 帳票作成日時, RString 並び順の１件目, RString 並び順の２件目,
            RString 並び順の３件目, RString 並び順の４件目, RString 並び順の５件目, List<RString> 改頁項目List,
            Association association) {
        this.通知書情報 = tsuchisyoJoho;
        this.調定年度 = 調定年度;
        this.帳票作成日時 = 帳票作成日時;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.改頁項目List = 改頁項目List;
        this.association = association;
    }

}
