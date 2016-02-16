/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.dbbbt35003;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面側からの出力帳票一覧データを定義したEntityクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class KariSanteiHenkoJoho {

    private RString 発行日;
    private RString 帳票分類ID;
    private TextBoxNum 帳票ID;
    private RString 処理区分;
    private RString 最初期;
    private RString association;
    private RString 賦課情報_更正後;
    private RString 賦課情報_更正前;
    private RString 納組情報;
    private RString 普徴納期情報リスト;
    private RString 特徴納期情報リスト;
    private RString 宛先情報;
    private RString 前年度賦課情報;
    private RString 減免情報;
    private RString 口座情報;
    private RString 徴収方法情報_更正後;
    private RString 対象者_追加含む_更正後;
    private RString 徴収方法情報_更正前;
    private RString 対象者_追加含む_更正前;
    private RString 収入情報;
    private RString 帳票制御共通情報;
    
    
 
}
