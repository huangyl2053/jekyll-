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
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseishoKanyurekiIdentifier;
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
    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private HokenshaNo 保険者番号;
    private Decimal 履歴番号;
    private Decimal 支給申請書整理番号;
    private RString 整理番号;
    private List<KogakuGassanShinseishoResult> 高額合算申請書;
    private List<KogakuGassanShinseishoKanyurekiResult> 加入歴;

    /**
     * 高額合算申請書取得のメソッドです。
     *
     * @param identifier KogakuGassanShinseishoIdentifier
     * @return KogakuGassanShinseishoResult
     */
    public KogakuGassanShinseishoResult get高額合算申請書(KogakuGassanShinseishoIdentifier identifier) {
        if (this.高額合算申請書 == null) {
            return null;
        }
        for (KogakuGassanShinseishoResult item : this.高額合算申請書) {
            if (item.get高額合算申請書().identifier().toString().equals(identifier.toString())) {
                return item;
            }
        }
        return null;
    }

    /**
     * 加入歴取得のメソッドです。
     *
     * @param identifier KogakuGassanShinseishoKanyurekiIdentifier
     * @return KogakuGassanShinseishoKanyurekiResult
     */
    public KogakuGassanShinseishoKanyurekiResult get加入歴(KogakuGassanShinseishoKanyurekiIdentifier identifier) {
        if (this.加入歴 == null) {
            return null;
        }
        for (KogakuGassanShinseishoKanyurekiResult item : this.加入歴) {
            if (item.get高額合算申請書加入歴().identifier().toString().equals(identifier.toString())) {
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
    public void add高額合算申請書(KogakuGassanShinseishoResult result) {
        if (this.高額合算申請書 == null) {
            this.高額合算申請書 = new ArrayList();
            this.高額合算申請書.add(result);
        }
        boolean flg = true;
        for (KogakuGassanShinseishoResult item : this.高額合算申請書) {
            if (item.get高額合算申請書().identifier().toString().equals(
                    result.get高額合算申請書().identifier().toString())) {
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
     * 加入歴追加のメソッドです。
     *
     * @param result 高額合算申請書
     */
    public void add加入歴(KogakuGassanShinseishoKanyurekiResult result) {
        if (this.加入歴 == null) {
            加入歴 = new ArrayList();
            加入歴.add(result);
        }
        boolean flg = true;
        for (KogakuGassanShinseishoKanyurekiResult item : this.加入歴) {
            if (item.get高額合算申請書加入歴().identifier().toString().equals(
                    result.get高額合算申請書加入歴().identifier().toString())) {
                this.加入歴.remove(item);
                this.加入歴.add(result);
                flg = false;
                break;
            }
        }
        if (flg) {
            this.加入歴.add(result);
        }
    }

    /**
     * 高額合算申請書削除のメソッドです。
     *
     * @param result 高額合算申請書
     */
    public void delete高額合算申請書(KogakuGassanShinseishoResult result) {
        if (this.高額合算申請書 == null) {
            return;
        }
        for (KogakuGassanShinseishoResult item : this.高額合算申請書) {
            if (item.get高額合算申請書().identifier().toString().equals(
                    result.get高額合算申請書().identifier().toString())) {
                this.高額合算申請書.remove(item);
                break;
            }
        }
    }

    /**
     * 加入歴追削除のメソッドです。
     *
     * @param result 高額合算申請書
     */
    public void delete加入歴(KogakuGassanShinseishoKanyurekiResult result) {
        if (this.加入歴 == null) {
            return;
        }
        for (KogakuGassanShinseishoKanyurekiResult item : this.加入歴) {
            if (item.get高額合算申請書加入歴().identifier().toString().equals(
                    result.get高額合算申請書加入歴().identifier().toString())) {
                this.加入歴.remove(item);
                break;
            }
        }
    }
}
