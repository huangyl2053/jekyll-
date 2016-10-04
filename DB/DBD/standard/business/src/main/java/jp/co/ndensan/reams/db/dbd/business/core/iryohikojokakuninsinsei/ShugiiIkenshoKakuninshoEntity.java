/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書確認書Entityクラスです。
 * 
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShugiiIkenshoKakuninshoEntity implements Serializable {
    private RString 宛名情報_送付先郵便番号;
    private RString 宛名情報_送付先行政区名;
    private RString 宛名情報_送付先住所3;
    private RString 宛名情報_送付先住所1;
    private RString 宛名情報_送付先住所2;
    private RString 宛名情報_送付先方書2;
    private RString 宛名情報_送付先方書2小;
    private RString 宛名情報_送付先方書1;
    private RString 宛名情報_送付先方書1小;
    private RString 宛名情報_代納人区分;
    private RString 宛名情報_送付先氏名12;
    private RString 宛名情報_送付先氏名12小;
    private RString 宛名情報_敬称付与12;
    private RString 宛名情報_送付先氏名11;
    private RString 宛名情報_送付先氏名11小;
    private RString 宛名情報_敬称付与11;
    private RString 宛名情報_左括弧2;
    private RString 宛名情報_送付先氏名22;
    private RString 宛名情報_送付先氏名22小;
    private RString 宛名情報_敬称付与22;
    private RString 宛名情報_右括弧2;
    private RString 宛名情報_左括弧1;
    private RString 宛名情報_送付先氏名21;
    private RString 宛名情報_送付先氏名21小;
    private RString 宛名情報_敬称付与21;
    private RString 宛名情報_右括弧1;
    private RString カスタマバーコード;
    private RString 役職名;
    private RString 役職名１;
    private RString 役職名２;
    private RString 認証者氏名;
    private RString 電子公印;
    private RString 公印文字列;
    private RString 認証者氏名掛けない;
    private RString 認証者氏名掛ける;
    private RString 公印書略;
    private RString 文書番号;
    private RString 発行日;
    private RString 申請日;
    private RString 住所;
    private RString 住所１;
    private RString 住所２;
    private RString 氏名;
    private RString 氏名１;
    private RString 氏名２;
    private RString 被保険者番号;
    private RString 主治医意見書作成日;
    private RString 要介護認定の有効期間開始;
    private RString 要介護認定の有効期間終了;
    private RString 寝たきり度_B1;
    private RString 寝たきり度_B2;
    private RString 寝たきり度_C1;
    private RString 寝たきり度_C2;
    private RString 尿失禁の発生可能性;
}
