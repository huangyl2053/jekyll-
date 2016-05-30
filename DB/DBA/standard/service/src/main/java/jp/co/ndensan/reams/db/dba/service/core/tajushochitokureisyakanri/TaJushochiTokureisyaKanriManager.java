/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tajushochitokureisyakanri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.tajushochitokureisya.TaJushochiTokureisyaKanriParameter;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tajushochitokureisyakanri.ITaJushochiTokureisyaKanriMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 他市町村住所地特例者管理を管理するクラスです。
 *
 * @reamsid_L DBA-0400-050 hezhenzhen
 *
 */
public class TaJushochiTokureisyaKanriManager {

    private final MapperProvider mapperProvider;
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 新規 = new RString("新規");

    /**
     * コンストラクタです。
     */
    TaJushochiTokureisyaKanriManager() {

        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    TaJushochiTokureisyaKanriManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TaJushochiTokureisyaKanriManager}のインスタンスを返します。
     *
     * @return // * {@link InstanceProvider#create}にて生成した{@link TaJushochiTokureisyaKanriManager}のインスタンス
     */
    public static TaJushochiTokureisyaKanriManager createInstance() {
        return InstanceProvider.create(TaJushochiTokureisyaKanriManager.class);
    }

    /**
     * 適用状態の適用情報を取得です。
     *
     * @param paramater TaJushochiTokureisyaKanriParameter
     */
    public void checkTekiyouJotai(List<TaJushochiTokureisyaKanriParameter> paramater) {

        List<TaJushochiTokureisyaKanriParameter> sortList = new ArrayList<>();

        for (TaJushochiTokureisyaKanriParameter date : paramater) {
            if (!新規.equals(date.get状態())) {
                sortList.add(date);
            }
        }
        if (sortList.isEmpty()) {
            return;
        }
        Collections.sort(sortList, new DateComparator());
        TaJushochiTokureisyaKanriParameter 直近適用グリッド行 = sortList.get(0);
        for (TaJushochiTokureisyaKanriParameter date : paramater) {

            if (新規.equals(date.get状態()) && !date.getNyuusyoYMD().isEmpty()
                    && !直近適用グリッド行.getTayishoYMD().isEmpty()
                    && !直近適用グリッド行.getKaijoYMD().isEmpty()
                    && (date.getNyuusyoYMD().isBefore(直近適用グリッド行.getTayishoYMD())
                    || date.getNyuusyoYMD().isBefore(直近適用グリッド行.getKaijoYMD()))) {
                throw new ApplicationException(
                        UrErrorMessages.期間が重複.getMessage());
            }
        }





    private static class DateComparator implements Comparator<TaJushochiTokureisyaKanriParameter>, Serializable {

        @Override
        public int compare(TaJushochiTokureisyaKanriParameter o1, TaJushochiTokureisyaKanriParameter o2) {
            return o1.getTekiyoYMD().compareTo(o2.getTekiyoYMD());
        }
        private static final long serialVersionUID = 5004135092514753307L;
    }

    /**
     * 解除状態の適用情報を取得です。
     *
     * @param paramater TaJushochiTokureisyaKanriParameter
     */
    public void checkKaijoJotai(List<TaJushochiTokureisyaKanriParameter> paramater) {
        for (TaJushochiTokureisyaKanriParameter date : paramater) {
            if (修正.equals(date.get状態()) && !date.getNyuusyoYMD().isEmpty()
                    && !date.getTayishoYMD().isEmpty()
                    && !date.getNyuusyoYMD().isBefore(date.getTayishoYMD())) {
                throw new ApplicationException(
                        UrErrorMessages.入力値が不正.getMessage());
            }
        }
        /**
         * 施設入退所情報情報の取得です。
         *
         * @param paramater TaJushochiTokureisyaKanriParameter
         */
    public void checkHenkoJotai(List<TaJushochiTokureisyaKanriParameter> paramater) {
        for (TaJushochiTokureisyaKanriParameter date : paramater) {
            if (追加.equals(date.get状態()) || 修正.equals(date.get状態())) {

                ITaJushochiTokureisyaKanriMapper mapper = mapperProvider.create(ITaJushochiTokureisyaKanriMapper.class);
                int count = mapper.select施設入退所情報リスト件数取得(date);
                if (count > 1) {
                    throw new ApplicationException(
                            UrErrorMessages.期間が重複.getMessage());
                }
            }
        }
    }
}
