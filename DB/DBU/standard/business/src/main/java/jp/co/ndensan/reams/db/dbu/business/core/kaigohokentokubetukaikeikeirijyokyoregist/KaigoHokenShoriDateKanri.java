/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.JigyoHokokuNenpoShoriName;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 処理日付管理マスタを管理するビジネスです。
 *
 * @reamsid_L DBU-1130-050 wangjie2
 */
public class KaigoHokenShoriDateKanri implements Serializable {

    private final KaigoHokenShoriDateKanriEntity 処理日付管理マスタ;

    /**
     * コンストラクタです。<br/>
     *
     * @param 処理日付管理マスタ 処理日付管理マスタ
     * @link KaigoHokenShoriDateKanriEntity}より{@link KaigoHokenShoriDateKanri}を生成します。
     *
     */
    public KaigoHokenShoriDateKanri(KaigoHokenShoriDateKanriEntity 処理日付管理マスタ) {
        this.処理日付管理マスタ = 処理日付管理マスタ;
    }

    /**
     * コンストラクタです。<br/>
     *
     */
    public KaigoHokenShoriDateKanri() {
        this.処理日付管理マスタ = new KaigoHokenShoriDateKanriEntity(SubGyomuCode.DBU介護統計報告, LasdecCode.EMPTY,
                JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成特別会計経理状況, RString.EMPTY, FlexibleYear.EMPTY, RString.EMPTY,
                FlexibleDate.EMPTY, null, FlexibleDate.EMPTY, FlexibleDate.EMPTY, null, null);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード LasdecCode
     * @param 処理名 JigyoHokokuNenpoShoriName
     * @param 処理枝番 RString
     * @param 年度 FlexibleYear
     * @param 年度内連番 RString
     * @param 基準年月日 FlexibleDate
     * @param 基準日時 RDateTime
     * @param 対象開始年月日 FlexibleDate
     * @param 対象終了年月日 FlexibleDate
     * @param 対象開始日時 YMDHMS
     * @param 対象終了日時 YMDHMS
     */
    public KaigoHokenShoriDateKanri(SubGyomuCode サブ業務コード, LasdecCode 市町村コード,
            JigyoHokokuNenpoShoriName 処理名, RString 処理枝番, FlexibleYear 年度, RString 年度内連番,
            FlexibleDate 基準年月日, RDateTime 基準日時, FlexibleDate 対象開始年月日,
            FlexibleDate 対象終了年月日, YMDHMS 対象開始日時, YMDHMS 対象終了日時) {
        this.処理日付管理マスタ = new KaigoHokenShoriDateKanriEntity(サブ業務コード, 市町村コード, 処理名, 処理枝番,
                年度, 年度内連番, 基準年月日, 基準日時, 対象開始年月日, 対象終了年月日, 対象開始日時, 対象終了日時);
    }

    /**
     * 処理日付管理マスタを返します。
     *
     * @return 処理日付管理マスタ
     */
    public KaigoHokenShoriDateKanriEntity get処理日付管理マスタ() {
        return 処理日付管理マスタ;
    }

    /**
     * 対象終了日時します。
     *
     * @return 対象終了日時
     */
    public YMDHMS get対象終了日時() {
        return 処理日付管理マスタ.get対象終了日時();
    }

    /**
     * 対象開始日時します。
     *
     * @return 対象開始日時
     */
    public YMDHMS get対象開始日時() {
        return 処理日付管理マスタ.get対象開始日時();
    }

    /**
     * 対象終了年月日します。
     *
     * @return 対象終了年月日
     */
    public FlexibleDate get対象終了年月日() {
        return 処理日付管理マスタ.get対象終了年月日();
    }

    /**
     * 対象開始年月日します。
     *
     * @return 対象開始年月日
     */
    public FlexibleDate get対象開始年月日() {
        return 処理日付管理マスタ.get対象開始年月日();
    }

    /**
     * 基準日時します。
     *
     * @return 基準日時
     */
    public RDateTime get基準日時() {
        return 処理日付管理マスタ.get基準日時();
    }

    /**
     * 基準年月日します。
     *
     * @return 基準年月日
     */
    public FlexibleDate get基準年月日() {
        return 処理日付管理マスタ.get基準年月日();
    }

    /**
     * 年度を返します。
     *
     * @return 年度
     */
    public FlexibleYear get年度() {
        return 処理日付管理マスタ.get年度();
    }

    /**
     * 年度内連番します。
     *
     * @return 年度内連番
     */
    public RString get年度内連番() {
        return 処理日付管理マスタ.get年度内連番();
    }

    /**
     * 処理枝番を返します。
     *
     * @return 処理枝番
     */
    public RString get処理枝番() {
        return 処理日付管理マスタ.get処理枝番();
    }

    /**
     * 処理名を返します。
     *
     * @return 処理名
     */
    public JigyoHokokuNenpoShoriName get処理名() {
        return 処理日付管理マスタ.get処理名();
    }

    /**
     * サブ業務コードを返します。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getサブ業務コード() {
        return 処理日付管理マスタ.getサブ業務コード();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 処理日付管理マスタ.get市町村コード();
    }

    /**
     * {@link JigyoHokokuTokeiData}のシリアライズ形式を提供します。
     *
     * @return {@link JigyoHokokuTokeiData}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(処理日付管理マスタ);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1;
        private final KaigoHokenShoriDateKanriEntity entity;

        private _SerializationProxy(KaigoHokenShoriDateKanriEntity entity) {
            this.entity = entity;
        }

        private Object readResolve() {
            return new KaigoHokenShoriDateKanri(this.entity);
        }
    }

}
