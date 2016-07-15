/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kakushutsuchisho;

import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TsuchiSho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種通知書発行パラメータ
 *
 * @reamsid_L DBB-1660-090 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KakushuTsuchiShoHakkoParameter {

    private Set<TsuchiSho> 発行帳票一覧;
    private FukaJoho 賦課の情報_更正前;
    private FukaJoho 賦課の情報_更正後;
    private FlexibleDate 決定_発行日;
    private RString 決定_文書番号;
    private FlexibleDate 変更_発行日;
    private RString 変更_文書番号;
    private List<RString> 調定事由リスト;
    private FlexibleDate 納入_発行日;
    private List<Kitsuki> 納入_出力期リスト;
    private RString 納入_出力形式;
    private List<Kitsuki> 郵振納付書_出力期リスト;
    private FlexibleDate 特徴開始_発行日;
    private FlexibleDate 減免_発行日;
    private RString 減免_文書番号;
    private FlexibleDate 徴収猶予_発行日;
    private RString 徴収猶予_文書番号;

}
