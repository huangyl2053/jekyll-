/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokkiimage;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項Entity。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaTokkiImageEntity {

    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 申請日_元号;
    private RString 申請日_年;
    private RString 申請日_月;
    private RString 申請日_日;
    private RString 作成日_元号;
    private RString 作成日_年;
    private RString 作成日_月;
    private RString 作成日_日;
    private RString 調査日_元号;
    private RString 調査日_年;
    private RString 調査日_月;
    private RString 調査日_日;
    private RString 審査日_元号;
    private RString 審査日_年;
    private RString 審査日_月;
    private RString 審査日_日;
    private RString 現ページ;
    private RString 総ページ数;
    private List<RString> 特記事項リスト番号;
    private List<RString> 特記事項リスト連番;
    private List<RString> 特記事項リスト名称;
    private List<RString> 特記事項リストイメージ;
    private RString 厚労省IF識別コード;
    private RString 概況特記事項イメージ;
    private RString 概況特記事項テキスト;
    private RString レイアウト;

}
