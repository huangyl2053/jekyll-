/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosachikuchichoson;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 調査地区情報ビジネスクラスです。
 */
public class UzT0007CodeBusiness {

    private final UzT0007CodeEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity コード種別管理のEntity
     */
    public UzT0007CodeBusiness(UzT0007CodeEntity entity) {
        this.entity = entity;
    }

    /**
     * サブ業務コードを取得します。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getサブ業務コード() {
        return entity.getサブ業務コード();
    }

    /**
     * コード種別を取得します。
     *
     * @return コード種別
     */
    public CodeShubetsu getコード種別() {
        return entity.getコード種別();
    }

    /**
     * コードを取得します。
     *
     * @return コード
     */
    public Code getコード() {
        return entity.getコード();
    }

    /**
     * 有効開始年月日を取得します。
     *
     * @return 有効開始年月日
     */
    public FlexibleDate get有効開始年月日() {
        return entity.get有効開始年月日();
    }

    /**
     * 有効終了日を取得します。
     *
     * @return 有効終了日
     */
    public FlexibleDate get有効終了日() {
        return entity.get有効終了年月日();
    }

    /**
     * コード名称を取得します。
     *
     * @return コード名称
     */
    public RString getコード名称() {
        return entity.getコード名称();
    }

    /**
     * コード略称を取得します。
     *
     * @return コード略称
     */
    public RString getコード略称() {
        return entity.getコード略称();
    }

    /**
     * オプション１を取得します。
     *
     * @return オプション１
     */
    public RString getオプション１() {
        return entity.getオプション１();
    }

    /**
     * オプション２を取得します。
     *
     * @return オプション２
     */
    public RString getオプション２() {
        return entity.getオプション２();
    }

    /**
     * オプション３を取得します。
     *
     * @return オプション３
     */
    public RString getオプション３() {
        return entity.getオプション３();
    }

    /**
     * 更新可否を取得します。
     *
     * @return 更新可否
     */
    public boolean is更新可否() {
        return entity.get更新可否区分();
    }

    /**
     * 表示順を取得します。
     *
     * @return 表示順
     */
    public int get表示順() {
        return entity.get表示順();
    }

}
