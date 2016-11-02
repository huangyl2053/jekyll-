/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogaku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseishoIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算申請書保持データです。
 *
 * @reamsid_L DBC-2040-040 huzongcheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShinseishoHoji implements Serializable {

    private RString メニューID;
    private RString 申請状態;
    private RString 申請状況;
    private boolean 訂正フラグ;
    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private HokenshaNo 保険者番号;
    private Decimal 履歴番号;
    private Decimal 支給申請書整理番号;
    private RString 整理番号;
    private List<KogakuGassanShinseishoRelate> 高額合算申請書;

    /**
     * 高額合算申請書取得のメソッドです。
     *
     * @param identifier KogakuGassanShinseishoIdentifier
     * @return KogakuGassanShinseishoResult
     */
    public KogakuGassanShinseishoRelate get高額合算申請書(KogakuGassanShinseishoIdentifier identifier) {
        if (this.高額合算申請書 == null) {
            return null;
        }
        for (KogakuGassanShinseishoRelate item : this.高額合算申請書) {
            if (item.identifier().toString().equals(identifier.toString())) {
                return item;
            }
        }
        return null;
    }

    /**
     * 高額合算申請書追加のメソッドです。
     *
     * @param result 高額合算申請書
     */
    public void add高額合算申請書(KogakuGassanShinseishoRelate result) {
        if (this.高額合算申請書 == null) {
            this.高額合算申請書 = new ArrayList();
            this.高額合算申請書.add(result);
        }
        boolean flg = true;
        for (KogakuGassanShinseishoRelate item : this.高額合算申請書) {
            if (item.identifier().toString().equals(
                    result.identifier().toString())) {
                this.高額合算申請書.remove(item);
                this.高額合算申請書.add(result);
                flg = false;
                break;
            }
        }
        if (flg) {
            this.高額合算申請書.add(result);
        }
    }

    /**
     * 高額合算申請書削除のメソッドです。
     *
     * @param result 高額合算申請書
     */
    public void delete高額合算申請書(KogakuGassanShinseishoRelate result) {
        if (this.高額合算申請書 == null) {
            return;
        }
        for (KogakuGassanShinseishoRelate item : this.高額合算申請書) {
            if (item.identifier().toString().equals(
                    result.identifier().toString())) {
                this.高額合算申請書.remove(item);
                break;
            }
        }
    }
}
