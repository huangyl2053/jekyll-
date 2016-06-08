/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コードマスタ保守シート(DBA介護資格)のコード種別を表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum DBACodeShubetsu {

    /**
     * コード:0001 コード種別名称:医療保険種類
     */
    医療保険種類("0001", "医療保険種類"),
    /**
     * コード:0002 コード種別名称:被保険者証交付事由
     */
    被保険者証交付事由("0002", "被保険者証交付事由"),
    /**
     * コード:0003 コード種別名称:被保険者証回収事由
     */
    被保険者証回収事由("0003", "被保険者証回収事由"),
    /**
     * コード:0004 コード種別名称:資格者証交付事由
     */
    資格者証交付事由("0004", "資格者証交付事由"),
    /**
     * コード:0005 コード種別名称:資格者証回収事由
     */
    資格者証回収事由("0005", "資格者証回収事由"),
    /**
     * コード:0006 コード種別名称:交付証種類
     */
    交付証種類("0006", "交付証種類"),
    /**
     * コード:0007 コード種別名称:介護資格取得事由（被保険者）
     */
    介護資格取得事由_被保険者("0007", "介護資格取得事由（被保険者）"),
    /**
     * コード:0008 コード種別名称:介護資格適用事由（他特例者）
     */
    介護資格適用事由_他特例者("0008", "介護資格適用事由（他特例者）"),
    /**
     * コード:0009 コード種別名称:介護資格適用事由（除外者）
     */
    介護資格適用事由_除外者("0009", "介護資格適用事由（除外者）"),
    /**
     * コード:0010 コード種別名称:介護資格喪失事由（被保険者）
     */
    介護資格喪失事由_被保険者("0010", "介護資格喪失事由（被保険者）"),
    /**
     * コード:0011 コード種別名称:介護資格解除事由（他特例者）
     */
    介護資格解除事由_他特例者("0011", "介護資格解除事由（他特例者）"),
    /**
     * コード:0012 コード種別名称:介護資格解除事由（除外者）
     */
    介護資格解除事由_除外者("0012", "介護資格解除事由（除外者）"),
    /**
     * コード:0013 コード種別名称:介護資格変更事由（被保険者）
     */
    介護資格変更事由被保険者("0013", "介護資格変更事由（被保険者）"),
    /**
     * コード:0014 コード種別名称:介護資格住特適用
     */
    介護資格住特適用("0014", "介護資格住特適用"),
    /**
     * コード:0015 コード種別名称:介護資格住特解除
     */
    介護資格住特解除("0015", "介護資格住特解除");

    private final CodeShubetsu code;
    private final RString fullName;

    private DBACodeShubetsu(String code, String fullname) {
        this.code = new CodeShubetsu(code);
        this.fullName = new RString(fullname);
    }

    /**
     * コードマスタ保守シート(DBA介護資格)のコード種別のコードを返します。
     *
     * @return コードマスタ保守シート(DBA介護資格)のコード種別のコード
     */
    public CodeShubetsu getコード() {
        return code;
    }

    /**
     * コードマスタ保守シート(DBA介護資格)のコード種別の名称を返します。
     *
     * @return コードマスタ保守シート(DBA介護資格)のコード種別のコード種別名称
     */
    public RString getコード種別名称() {
        return fullName;
    }

    /**
     * コードマスタ保守シート(DBA介護資格)のコード種別のコードと一致する内容を探します。
     *
     * @param code コードマスタ保守シート(DBA介護資格)のコード種別のコード
     * @return {@code code} に対応するコードマスタ保守シート(DBA介護資格)のコード種別
     */
    public static DBACodeShubetsu toValue(CodeShubetsu code) {
        for (DBACodeShubetsu codeShubetsu : DBACodeShubetsu.values()) {
            if (codeShubetsu.code.equals(code)) {
                return codeShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("コードマスタ保守シート(DBA介護資格)のコード種別"));
    }
}
