/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局用その他資料情報のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuSonotashiryoBusiness {

    private static final int INDEX_5 = 5;
    private final ShinsakaiSiryoKyotsuEntity entity;
    private final List<RString> ファイル名List;
    private final int 存在ファイルindex;
    private RString 事務局概況特記イメージパス;

    /**
     * コンストラクタです。
     *
     * @param entity ShinsakaiSiryoKyotsuEntity
     * @param ファイル名List 存在ファイルindex
     * @param 存在ファイルindex int
     */
    public JimuSonotashiryoBusiness(ShinsakaiSiryoKyotsuEntity entity, List<RString> ファイル名List, int 存在ファイルindex) {
        this.entity = entity;
        this.ファイル名List = ファイル名List;
        this.存在ファイルindex = 存在ファイルindex;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo().value();
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 識別コードは証記載保険者番号（左から5桁）+被保険者番号を設定してください。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        if (RString.isNullOrEmpty(entity.getShoKisaiHokenshaNo()) || RString.isNullOrEmpty(entity.getHihokenshaNo())) {
            return RString.EMPTY;
        }
        return entity.getShoKisaiHokenshaNo().substring(0, INDEX_5).concat(entity.getHihokenshaNo());
    }

    /**
     * 名前を取得します。
     *
     * @return 名前
     */
    public RString get名前() {
        return entity.getHihokenshaName().getColumnValue();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定調査実施年月日を取得します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 介護認定審査会開催年月日を取得します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 左のその他資料イメージを取得します。
     *
     * @param index index
     * @return 左のその他資料イメージ
     */
    public RString get左のその他資料イメージ(int index) {
        if (ファイル名List != null && index < ファイル名List.size()) {
            return ファイル名List.get(index);
        }
        return RString.EMPTY;
    }

    /**
     * 右のその他資料イメージを取得します。
     *
     * @param index index
     * @return 右のその他資料イメージ
     */
    public RString get右のその他資料イメージ(int index) {
        if (ファイル名List != null && index < ファイル名List.size()) {
            return ファイル名List.get(index);
        }
        return RString.EMPTY;
    }

    /**
     * 事務局概況特記イメージを取得します。
     *
     * @return 事務局概況特記イメージ
     */
    public RString get事務局概況特記イメージ() {
        return 事務局概況特記イメージパス;
    }

    /**
     * 事務局概況特記イメージを設定します。
     *
     * @param イメージパス イメージパス
     */
    public void set事務局概況特記イメージ(RString イメージパス) {
        this.事務局概況特記イメージパス = イメージパス;
    }

    /**
     * その他資料イメージリストを取得します。
     *
     * @return その他資料イメージ
     */
    public List<RString> getその他資料() {
        return ファイル名List;
    }

    /**
     * その他資料を取得します。
     *
     * @return その他資料
     */
    public int get存在ファイルIndex() {
        return 存在ファイルindex;
    }
}
