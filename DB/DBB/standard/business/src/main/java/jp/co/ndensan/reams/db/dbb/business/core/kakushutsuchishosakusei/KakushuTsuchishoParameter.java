/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種通知書発行パラメータのクラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KakushuTsuchishoParameter implements Serializable {

    private List<RString> 発行する帳票List;
    private FukaJoho 賦課の情報_更正前;
    private FukaJoho 賦課の情報_更正後;
    private FlexibleDate 決定通知書_発行日;
    private RString 決定通知書_文書番号;
    private FlexibleDate 変更通知書_発行日;
    private RString 変更通知書_文書番号;
    private TyouteiZiyu 調定事由List;
    private FlexibleDate 納入通知書_発行日;
    private RString 納入通知書_出力期;
    private RString 納入通知書_出力形式;
    private RString 郵振納付書_出力期;
    private FlexibleDate 特徴開始通知書_発行日;
    private FlexibleDate 減免通知書_発行日;
    private RString 減免通知書_文書番号;
    private FlexibleDate 徴収猶予通知書_発行日;
    private RString 徴収猶予通知書_文書番号;
    private List<Kitsuki> 納入通知書_出力期リスト;
}
